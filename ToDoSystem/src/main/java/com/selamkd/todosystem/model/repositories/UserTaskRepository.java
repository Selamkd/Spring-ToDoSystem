package com.selamkd.todosystem.model.repositories;

import com.selamkd.todosystem.model.entities.UserTask;
import com.selamkd.todosystem.model.entities.UserTaskId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTaskRepository extends JpaRepository<UserTask, UserTaskId> {
}