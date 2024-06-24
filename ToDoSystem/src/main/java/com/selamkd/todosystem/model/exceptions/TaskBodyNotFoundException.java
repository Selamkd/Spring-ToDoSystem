package com.selamkd.todosystem.model.exceptions;

public class TaskBodyNotFoundException extends Exception {
    public TaskBodyNotFoundException(){
        super("The task body is missing from the request. Please include a task and try again.");
    }
}
