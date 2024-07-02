package com.selamkd.todosystem.controller;

import com.selamkd.todosystem.model.exceptions.TasksNotFoundException;
import com.selamkd.todosystem.model.repositories.TaskRepository;
import com.selamkd.todosystem.service.TaskService;
import com.selamkd.todosystem.service.TaskServiceImp;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class TaskWebController {

    TaskServiceImp taskService;

    @GetMapping("/web/home")
    public String getHome(Model model){

        return "home";
    }

    @GetMapping("/web/tasks")
    public String getTasks(Model model) throws TasksNotFoundException {
        model.addAttribute("tasks", taskService.getAllTasks());
        return "tasks";
    }

    @GetMapping("/web/task/{id}")
    public String getTask(@PathVariable String id,  Model model){
        model.addAttribute("tasks", taskService.getTaskById(id));
        return "task";
    }

}
