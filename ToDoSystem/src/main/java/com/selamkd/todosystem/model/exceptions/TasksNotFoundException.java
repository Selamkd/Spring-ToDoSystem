package com.selamkd.todosystem.model.exceptions;

public class TasksNotFoundException extends Exception {

    public TasksNotFoundException(){
        super("There are no tasks available at the moment.");
    }
}
