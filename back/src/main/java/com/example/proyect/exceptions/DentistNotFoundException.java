package com.example.proyect.exceptions;

public class DentistNotFoundException extends Exception{
    public DentistNotFoundException() {
        super("Dentist not found");
    }
}
