package com.example.proyect.exceptions;

public class AppNotFoundException extends Exception{
    public AppNotFoundException() {
        super("Couldn't found the appointment");
    }
}
