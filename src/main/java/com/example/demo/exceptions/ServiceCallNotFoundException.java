package com.example.demo.exceptions;

public class ServiceCallNotFoundException extends RuntimeException{//יורש מהמחלה של השגיאות!!!!!!!
    public ServiceCallNotFoundException(String message) {
        super(message);
    }
}
