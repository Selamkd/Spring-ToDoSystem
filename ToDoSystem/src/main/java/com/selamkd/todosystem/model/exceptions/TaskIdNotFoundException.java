package com.selamkd.todosystem.model.exceptions;

public class TaskIdNotFoundException extends Exception {

    public TaskIdNotFoundException(String taskId) {
        super("Task with ID " + taskId + " not found. Please check the ID and try again.");
    }
}
