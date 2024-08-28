package com.selamkd.todosystem;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.selamkd.todosystem.controller.TaskController;
import com.selamkd.todosystem.model.entities.Task;
import com.selamkd.todosystem.model.exceptions.TaskIdNotFoundException;
import com.selamkd.todosystem.model.exceptions.TasksNotFoundException;
import com.selamkd.todosystem.service.TaskService;
import com.selamkd.todosystem.service.TaskServiceImp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.*;

import static org.mockito.Mockito.when;

@WebMvcTest
public class TaskControllerTests {
    //Inject the mock TaskService into the TaskController instance
    @InjectMocks
    TaskController taskController;
    //MockMvc instance for simulating HTTP requests to controllers
    @Autowired
    private MockMvc mockMvc;
    //Wires a mock instance of TaskService into the Spring context
    @MockBean
    private TaskServiceImp taskService;

    @Test
    @DisplayName("Check that adding a new task returns 'Task added successfully'")
    void checkThatAddingANewTaskReturnsTaskAddedSuccessfully() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/task")
                        .contentType("application/json")
                        .content("""
                                { \
                                "title": "Udemy OOP course",
                                "description": "Watch Udemy OOP course, take quiz and build  workbook project",
                                "status": "PENDING",
                                "users": []\
                                }""")
                        .accept("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Task added successfully"));


    }

    @Test
    @DisplayName("Check that adding a new task without task body throws TaskBodyNotFoundException")
    void checkThatAddingNewTaskWithoutTaskBodyThrowsException() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/task")
                        .contentType("application/json")
                        .content("")
                        .accept("application/json"))
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());

    }


    @Test
    @DisplayName("Check get all tasks returns list of tasks and status 200")
    void checkGetAllTasksReturnsListOfTasksAndStatus200() throws Exception {
        Task task1 = new Task();
        task1.setTitle("Task 1");
        task1.setDescription("Task 1 description");
        Task task2 = new Task();
        task2.setTitle("Task 2");
        task2.setDescription("Task 2 description");

        List<Task> tasks = Arrays.asList(task1, task2);
        ObjectMapper objectMapper = new ObjectMapper();
        String expectedJsonResponse = objectMapper.writeValueAsString(tasks);
        when(taskService.getAllTasks()).thenReturn(tasks);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/tasks")
                        .contentType("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(expectedJsonResponse));


    }

    @Test
    @DisplayName("Check get all tasks throws TasksNotFound exception when there are no tasks")
    void checkGetAllTasksThrowsExceptionWhenNoTasks() throws Exception {

        when(taskService.getAllTasks()).thenThrow( new TasksNotFoundException());

        mockMvc.perform(MockMvcRequestBuilders.get("/api/tasks")
                        .contentType("application/json"))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(result -> Assertions.assertInstanceOf(TasksNotFoundException.class, result.getResolvedException()))
                .andExpect(result -> Assertions.assertEquals("There are no tasks available at the moment.", Objects.requireNonNull(result.getResolvedException()).getMessage()));


    }


    @Test
    @DisplayName("Check get task by id returns a matching task and 200 status code")
    void checkGetTaskByIdReturnsAMatchingTaskAnd200StatusCode() throws Exception {
        Task task1 = new Task();
        task1.setTitle("Task 1");
        task1.setDescription("Task 1 description");
        Task task2 = new Task();
        task2.setTitle("Task 2");
        task2.setDescription("Task 2 description");

        ObjectMapper objectMapper = new ObjectMapper();
        String expectedJsonResponse = objectMapper.writeValueAsString(task1);

        when(taskService.getTaskById("1")).thenReturn(Optional.of(task1));
        when(taskService.getTaskById("2")).thenReturn(Optional.of(task2));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/task/1")
                        .contentType("application/json"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(expectedJsonResponse));


    }



    @Test
    @DisplayName("Given no ID should return TaskIDNotFoundException")
    void givenNoIdShouldReturnTaskIdNotFoundException() throws Exception {

        when(taskService.getTaskById("-")).thenThrow( new TaskIdNotFoundException("-"));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/task/-")
                        .contentType("application/json"))
                .andExpect(MockMvcResultMatchers.status().isNotFound())
                .andExpect(result -> Assertions.assertInstanceOf(TaskIdNotFoundException.class, result.getResolvedException()))
                .andExpect(result -> Assertions.assertEquals("Task with ID " + "-" + " not found. Please check the ID and try again.", Objects.requireNonNull(result.getResolvedException()).getMessage()));


    }




}