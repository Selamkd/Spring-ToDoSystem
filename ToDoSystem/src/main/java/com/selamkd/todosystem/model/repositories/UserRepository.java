package com.selamkd.todosystem.model.repositories;

import com.selamkd.todosystem.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}