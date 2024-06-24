package com.selamkd.todosystem.model.exceptions;

public record ResponseBody(int statusCode, String url, String message) {
}
