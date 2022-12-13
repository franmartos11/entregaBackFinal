package com.example.proyect.exceptions;

public class AppNoContException extends Exception{
    public AppNoContException() {
        super("There arent turns on the data base");
    }
}
