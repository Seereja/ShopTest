package com.example.springtest.exeptions;

public class ResourseNotFoundException extends Exception {
    public ResourseNotFoundException(String message) {
        super(message);
    }
}
