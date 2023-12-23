package com.example.library.model.exceptions;

public class DataNotFoundException extends RuntimeException{
    public DataNotFoundException(String msg) {
        super(msg);
    }
}
