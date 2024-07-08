package com.selamkd.todosystem;

import com.selamkd.todosystem.model.entities.Task;
import com.selamkd.todosystem.service.TaskServiceImp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;


@SpringBootApplication
public class ToDoSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(ToDoSystemApplication.class, args);
    }

}
