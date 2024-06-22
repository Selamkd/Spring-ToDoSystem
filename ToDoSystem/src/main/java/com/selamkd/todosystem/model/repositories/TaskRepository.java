package com.selamkd.todosystem.model.repositories;

import com.selamkd.todosystem.model.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer> {

    List<Task> findByTitleContaining(String title);
    List<Task> findByUsers_Id(Integer userId);
    List<Task> findByUsers_UserName(String name);

}