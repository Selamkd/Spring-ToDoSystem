package com.selamkd.todosystem.service;

import com.selamkd.todosystem.model.repositories.TaskRepository;
import com.selamkd.todosystem.model.entities.Task;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> getTaskById(Integer id) {
        if (id == null) {
            return Optional.empty();
        }
        return taskRepository.findById(id);
    }

    public void deleteTasKById(Integer id) {
        Optional<Task> tasks = taskRepository.findById(id);
        tasks.ifPresent(taskRepository::delete);
        // throw an exception
    }

    public List<Task> findTaskByTitle(String title) {
        String titleLower = title.toLowerCase();
        return taskRepository.findByTitleContaining(titleLower);

    }

    public List<Task> findTaskByUserID(Integer userID) {
        return taskRepository.findByUsers_Id(userID);
    }

    public List<Task> findTaskByUserName(String userName) {
        return taskRepository.findByUsers_name(userName);
    }

    public List<Task> findTaskByCreatedDateBetween(LocalDate startDate, LocalDate endDate) {
         return taskRepository.findByCreatedAtBetween(startDate, endDate);
    }
}