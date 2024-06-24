package com.selamkd.todosystem.model.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TaskExceptionAdvice {

    @ExceptionHandler(TaskBodyNotFoundException.class)
    public ResponseEntity<ResponseBody> handleTaskBodyNotFoundException(TaskBodyNotFoundException e, HttpServletRequest request){
        ResponseBody response = new ResponseBody(HttpStatus.NOT_FOUND.value(),
                request.getRequestURL().toString(),
                e.getMessage());

        return ResponseEntity.status( HttpStatus.NOT_FOUND).body(response);
    }
}
