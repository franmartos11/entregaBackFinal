package com.example.proyect.exceptions;

public class UserNotFoundException extends Exception{
    public UserNotFoundException() {
        super("User not found");
    }
}
