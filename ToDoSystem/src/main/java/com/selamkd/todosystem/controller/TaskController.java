package com.selamkd.todosystem.controller;

import com.selamkd.todosystem.model.entities.Task;
import com.selamkd.todosystem.model.exceptions.TaskBodyNotFoundException;
import com.selamkd.todosystem.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("task")
    public String addTask(@RequestBody Optional<Task> task) throws TaskBodyNotFoundException {
        if (task.isEmpty()) {
            throw new TaskBodyNotFoundException();
        }else{
            taskService.saveTask(task.get());
            return "Task added successfully";
        }
    }

    @GetMapping("/tasks")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }




}
