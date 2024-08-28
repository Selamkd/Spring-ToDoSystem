package com.selamkd.todosystem.controller;

import com.selamkd.todosystem.model.entities.Task;
import com.selamkd.todosystem.model.exceptions.ListNotFoundException;
import com.selamkd.todosystem.model.exceptions.RequestBodyNotFoundException;
import com.selamkd.todosystem.model.exceptions.TaskIdNotFoundException;
import com.selamkd.todosystem.model.exceptions.TaskNotFoundException;
import com.selamkd.todosystem.service.TaskServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class TaskController {

    private final TaskServiceImp taskService;


    @Autowired
    public TaskController(TaskServiceImp  taskService) {
        this.taskService = taskService;

    }

    @PostMapping("task")
    public String addTask(@RequestBody Optional<Task> task) throws  RequestBodyNotFoundException {
        if (task.isEmpty()) {
            throw new RequestBodyNotFoundException("Task body not missing from request.Please check your input and try again");
        } else {
            taskService.saveTask(task.get());
            return "Task added successfully";
        }
    }

    @GetMapping("/tasks")
    public List<Task> getAllTasks() throws ListNotFoundException {
        List<Task> tasks = taskService.getAllTasks();
        if (tasks.isEmpty()) {
            throw new ListNotFoundException("There are no tasks available at the moment. Please try again later.");
        }
        return tasks;
    }

    @GetMapping("/task/{taskId}")
    public Optional<Task> getTaskById(@PathVariable String taskId) throws TaskIdNotFoundException {
        if (taskId == null || taskId.isEmpty()) {
            throw new TaskIdNotFoundException(taskId);
        }

        return taskService.getTaskById(taskId);
    }


    @PutMapping("task/{taskId}")
    public Task updateTask(@PathVariable String taskId, @RequestBody Task task) throws TaskIdNotFoundException, RequestBodyNotFoundException {
        Optional<Task> taskToUpdate = taskService.getTaskById(taskId);
        if (task == null) {
            throw new RequestBodyNotFoundException("Task body not missing from request.Please check your input and try again");
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
