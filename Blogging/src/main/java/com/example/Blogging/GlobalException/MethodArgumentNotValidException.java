package com.example.Blogging.globalexception;

public class MethodArgumentNotValidException extends RuntimeException {

    public MethodArgumentNotValidException() {
    }


    public MethodArgumentNotValidException(String message) {
        super(message);
    }
}
