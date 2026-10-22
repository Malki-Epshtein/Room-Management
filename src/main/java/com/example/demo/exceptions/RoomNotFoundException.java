package com.example.demo.exceptions;

public class RoomNotFoundException  extends RuntimeException{
    public RoomNotFoundException(String message) {
        super(message);
    }

}
