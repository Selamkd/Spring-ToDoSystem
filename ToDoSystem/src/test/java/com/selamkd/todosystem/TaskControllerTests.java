package com.selamkd.todosystem;

import com.selamkd.todosystem.controller.TaskController;
import com.selamkd.todosystem.service.TaskService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest
public class TaskControllerTests {
   //MockMvc instance for simulating HTTP requests to controllers
   @Autowired
   private MockMvc mockMvc;
   //Wires a mock instance of TaskService into the Spring context
   @MockBean
   private TaskService taskService;
   //Inject the mock TaskService into the TaskController instance
   @InjectMocks
   TaskController taskController;



   @Test
   @DisplayName("Check that adding a new task returns 'Task added successfully'")
   void checkThatAddingANewTaskReturnsTaskAddedSuccessfully() throws Exception {
      mockMvc.perform(MockMvcRequestBuilders.post("/api/task")
                      .contentType("application/json")
                      .content("""
                              { \
                              "title": "Udemy OOP course",
                              "description": "Watch Udemy OOP course, take quiz and build the workbook project",
                              "status": "PENDING",
                              "users": []\
                              }""")
                      .accept("application/json"))
                      .andExpect(MockMvcResultMatchers.status().isOk())
                      .andExpect(MockMvcResultMatchers.content().string("Task added successfully"));



   }

   @Test
   @DisplayName("Check that adding a new task without task body throws TaskBodyNotFoundException")
   void checkThatAddingNewTaskWithoutTaskBodyThrowsException () throws Exception{
      mockMvc.perform(MockMvcRequestBuilders.post("/api/task")
              .contentType("application/json")
              .content("")
              .accept("application/json"))
              .andExpect(MockMvcResultMatchers.status().is4xxClientError());

   }


}
