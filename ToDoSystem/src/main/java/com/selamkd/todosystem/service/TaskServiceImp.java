package com.selamkd.todosystem.service;

import com.selamkd.todosystem.model.entities.Task;
import com.selamkd.todosystem.model.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImp implements TaskService {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskServiceImp(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task saveTask(Task task) {
        task.setCreatedAt(LocalDateTime.now());
        return taskRepository.save(task);
    }

    public Task updateTask(String id, Task updatedTask) {
        Optional<Task> taskOptional = taskRepository.findById(Integer.valueOf(id));
        if (taskOptional.isPresent()) {
            Task taskToUpdate = taskOptional.get();
            taskToUpdate.setTitle(updatedTask.getTitle());
            taskToUpdate.setDescription(updatedTask.getDescription());
            taskToUpdate.setCreatedAt(LocalDateTime.now());

            return taskRepository.save(taskToUpdate);
        } else {
            return null;
        }
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> getTaskById(String  id) {
        if (id == null) {
            return Optional.empty();
        }
        return taskRepository.findById(Integer.valueOf(id));
    }

    public boolean deleteTaskById(String id) {
        Optional<Task> tasks = taskRepository.findById(Integer.valueOf(id));
        tasks.ifPresent(taskRepository::delete);

        if(tasks.isPresent()) {
            taskRepository.delete(tasks.get());
            return true;
        }
        return false;
    }

    public List<Task> findTaskByTitle(String title) {
        String titleLower = title.toLowerCase();
        return taskRepository.findByTitleContaining(titleLower);

    }

    public List<Task> findTaskByUserId(String userID) {
        return taskRepository.findByUsers_Id(Integer.valueOf(userID));
    }

    public List<Task> findTaskByUserName(String userName) {
        return taskRepository.findByUsers_UserName(userName);
    }


}