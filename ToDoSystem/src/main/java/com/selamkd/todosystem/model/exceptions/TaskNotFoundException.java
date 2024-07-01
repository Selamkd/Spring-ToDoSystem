package com.selamkd.todosystem.model.exceptions;

public class TaskNotFoundException extends Exception{
    public TaskNotFoundException() {
        super("Task not found.Please check your input and try again.");
    }
}
