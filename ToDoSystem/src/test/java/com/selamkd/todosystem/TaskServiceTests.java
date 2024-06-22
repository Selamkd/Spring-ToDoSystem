package com.selamkd.todosystem;

import com.selamkd.todosystem.model.entities.Task;
import com.selamkd.todosystem.model.repositories.TaskRepository;
import com.selamkd.todosystem.service.TaskServiceImp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@SpringBootTest
public class TaskServiceTests {
    @Autowired
    private TaskServiceImp taskService;
    @MockBean
    private TaskRepository taskRepository;


    @Test
    @DisplayName("addNewTask_ successfully adds a task to the tasks table")
    void addNewTask_AddsATaskToTheTasksTable() {
        Task taskEntity = new Task();
        taskEntity.setTitle("Testing a new task");
        taskEntity.setStatus("Pending");
        taskEntity.setDescription("Testing a new task description");
        //--------------------------------------------------------//
        Mockito.when(taskRepository.save(taskEntity)).thenReturn(taskEntity);
        Task savedTask = taskService.saveTask(taskEntity);
        //------------------------------------------------------//
        Assertions.assertNotNull(savedTask);
        Assertions.assertEquals(taskEntity.getId(), savedTask.getId());
        Assertions.assertEquals(taskEntity.getTitle(), savedTask.getTitle());
        Assertions.assertEquals(taskEntity.getStatus(), savedTask.getStatus());
    }


    @Test
    @DisplayName("getAllTasks_ returns all tasks in the database")
    void getAllTasks_ReturnsAllTasksInTheDatabase() {

        Task task1 = new Task();
        task1.setTitle("Task 1 test title");
        task1.setStatus("Pending");
        task1.setDescription("Task 1 test description");
        Task task2 = new Task();
        task2.setTitle("Task 2 test title");
        task2.setStatus("Pending");
        task2.setDescription("Task 2 test description");

        // when findAll() is called on taskRepository return task 1 and task 2 as list
        when(taskRepository.findAll()).thenReturn(Arrays.asList(task1, task2));
        List<Task> tasks = taskService.getAllTasks();
        Assertions.assertNotNull(tasks);
        Assertions.assertEquals(2, tasks.size());
        Assertions.assertEquals(task1, tasks.getFirst());
        Assertions.assertEquals(task2, tasks.getLast());


    }


    @Test
    @DisplayName("getTaskById_ returns task with matching id")
    void getTaskById_ReturnsTaskWithMatchingId() {
        Task task1 = new Task();
        task1.setTitle("Task 1 test title");
        task1.setStatus("Pending");
        task1.setDescription("Task 1 test description");
        Task task2 = new Task();
        task2.setTitle("Task 2 test title");
        task2.setStatus("Pending");
        task2.setDescription("Task 2 test description");

        when(taskRepository.findById(1)).thenReturn(Optional.of(task1));
        when(taskRepository.findById(2)).thenReturn(Optional.of(task2));

        Optional<Task> task = taskService.getTaskById(1);
        Assertions.assertTrue(task.isPresent());
        Assertions.assertNotNull(taskService.getTaskById(2));

        Assertions.assertEquals("Task 1 test title", task.get().getTitle());


    }


    @Test
    @DisplayName("updateTask_ update a task entity and returns the updated task")
    void updateTaskUpdateATaskEntityAndReturnsTheUpdatedTask() {

        Task existingTask = new Task();
        existingTask.setTitle("Task 1 test title");
        existingTask.setStatus("Pending");
        existingTask.setDescription("Task 1 test description");

        Task updatedTask = new Task();
        updatedTask.setTitle("Task 2 test title");

        when(taskRepository.findById(1)).thenReturn(Optional.of(existingTask));
        when(taskRepository.save(existingTask)).thenReturn(updatedTask);

        Task savedTask = taskService.updateTask(1, updatedTask);

        Assertions.assertNotNull(savedTask);

        Assertions.assertEquals("Task 2 test title", savedTask.getTitle());

    }



    @Test
    @DisplayName("deleteTaskById_ deletes a record from the table")
    void deleteTaskByIdDeletesARecordFromTheTable() {
        Task task = new Task();
        task.setTitle("Task 1 test title");
        task.setStatus("Pending");
        task.setDescription("Task 1 test description");

        when(taskRepository.findById(1)).thenReturn(Optional.of(task));
        taskRepository.deleteById(1);
        boolean deleted = taskService.deleteTaskById(1);

        Assertions.assertTrue(deleted);

    }




}
