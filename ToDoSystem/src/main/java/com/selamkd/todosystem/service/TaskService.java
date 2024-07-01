package com.selamkd.todosystem.service;

import com.selamkd.todosystem.model.entities.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    Task saveTask(Task task);

    List<Task> getAllTasks();

    Task updateTask(String taskId, Task task);

    Optional<Task> getTaskById(String id);

    boolean deleteTaskById(String id);

    List<Task> findTaskByTitle(String title);

    List<Task> findTaskByUserId(String userId);

    List<Task> findTaskByUserName(String userName);




}