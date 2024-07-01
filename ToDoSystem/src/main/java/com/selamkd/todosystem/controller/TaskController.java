package com.selamkd.todosystem.controller;

import com.selamkd.todosystem.model.entities.Task;
import com.selamkd.todosystem.model.exceptions.TaskBodyNotFoundException;
import com.selamkd.todosystem.model.exceptions.TaskIdNotFoundException;
import com.selamkd.todosystem.model.exceptions.TaskNotFoundException;
import com.selamkd.todosystem.model.exceptions.TasksNotFoundException;
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
        } else {
            taskService.saveTask(task.get());
            return "Task added successfully";
        }
    }

    @GetMapping("/tasks")
    public List<Task> getAllTasks() throws TasksNotFoundException {
        List<Task> tasks = taskService.getAllTasks();
        if (tasks.isEmpty()) {
            throw new TasksNotFoundException();
        }
        return tasks;
    }

    @GetMapping("/task/{taskId}")
    public Optional<Task> getTaskById(@PathVariable String taskId) throws TaskIdNotFoundException, TasksNotFoundException {
        if (taskId == null || taskId.isEmpty()) {
            throw new TaskIdNotFoundException(taskId);
        }

        return taskService.getTaskById(taskId);
    }


    @PutMapping("task/{taskId}")
    public Task updateTask(@PathVariable String taskId, @RequestBody Task task) throws TaskBodyNotFoundException, TaskIdNotFoundException, TasksNotFoundException {
        Optional<Task> taskToUpdate = taskService.getTaskById(taskId);
        if (task == null) {
            throw new TaskBodyNotFoundException();
        }
        if (taskToUpdate.isEmpty()) {
            throw new TaskIdNotFoundException(taskId);
        }
        return taskService.updateTask(taskId, task);


    }

    @DeleteMapping("task/{taskId}")
    public String deleteTaskById(@PathVariable String taskId) throws TaskIdNotFoundException {
        if (taskId == null || taskId.isEmpty()) {
            throw new TaskIdNotFoundException(taskId);
        }

        taskService.deleteTaskById(taskId);
        return "Task with id " + taskId + " deleted successfully";
    }

    @GetMapping("task/title")
    public List<Task> getTaskByTitle(@RequestParam String title) throws TaskNotFoundException {
        if (title == null || title.isEmpty()) {
            throw new TaskNotFoundException();
        }
        return taskService.findTaskByTitle(title);
    }

    @GetMapping("task/user")
    public List<Task> getTaskByUserName(@RequestParam String userName) throws TaskNotFoundException {
        if (userName == null || userName.isEmpty()) {
            throw new TaskNotFoundException();
        }
        return taskService.findTaskByUserName(userName);
    }

    @GetMapping("task/user/{id}")
    public List<Task> getTaskByUserId(@PathVariable String id) throws TaskNotFoundException {
        if (id == null || id.isEmpty()) {
            throw new TaskNotFoundException();
        }
        return taskService.findTaskByUserId(id);
    }

}
