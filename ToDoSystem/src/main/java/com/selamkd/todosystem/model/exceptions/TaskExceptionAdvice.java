package com.selamkd.todosystem.model.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TaskExceptionAdvice {

    @ExceptionHandler(RequestBodyNotFoundException.class)
    public ResponseEntity<ResponseBody> handleTaskBodyNotFoundException(RequestBodyNotFoundException e, HttpServletRequest request){
        ResponseBody response = new ResponseBody(HttpStatus.NOT_FOUND.value(),
                request.getRequestURL().toString(),
                e.getMessage());

        return ResponseEntity.status( HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(ListNotFoundException.class)
    public ResponseEntity<ResponseBody> handleTasksNotFoundException(ListNotFoundException e, HttpServletRequest request){
        ResponseBody response = new ResponseBody(HttpStatus.NOT_FOUND.value(),
                request.getRequestURL().toString(),
                e.getMessage());

        return ResponseEntity.status( HttpStatus.NOT_FOUND).body(response);
    }
    @ExceptionHandler(TaskNotFoundException.class)
    public ResponseEntity<ResponseBody> handleTaskNotFoundException(TaskNotFoundException e, HttpServletRequest request){
        ResponseBody response = new ResponseBody(HttpStatus.NOT_FOUND.value(),
                request.getRequestURL().toString(),
                e.getMessage());

        return ResponseEntity.status( HttpStatus.NOT_FOUND).body(response);
    }
    @ExceptionHandler(IdNotFoundException.class)
    public ResponseEntity<ResponseBody> handleTaskIdNotFoundException(IdNotFoundException e, HttpServletRequest request){
        ResponseBody response = new ResponseBody(HttpStatus.NOT_FOUND.value(),
                request.getRequestURL().toString(),
                e.getMessage());

        return ResponseEntity.status( HttpStatus.NOT_FOUND).body(response);
    }
}
