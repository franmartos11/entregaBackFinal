package com.example.proyect.exceptions;

public class UserNoContException extends Exception{
    public UserNoContException() {
        super("There arent users on the data base");
    }
}
