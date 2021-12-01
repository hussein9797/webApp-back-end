package com.example.demo.Excptions;

public class NotFoundException extends  RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
