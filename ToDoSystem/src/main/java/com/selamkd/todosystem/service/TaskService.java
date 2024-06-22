package com.selamkd.todosystem.service;

import com.selamkd.todosystem.model.entities.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    Task saveTask(Task task);

    List<Task> getAllTasks();

    Optional<Task> getTaskById(Integer id);

    boolean deleteTaskById(Integer id);

    List<Task> findTaskByTitle(String title);

    List<Task> findTaskByUserId(Integer userId);

    List<Task> findTaskByUserName(String userName);




}