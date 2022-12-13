package com.example.proyect.exceptions;

public class PatientNotFoundException extends Exception{
    public PatientNotFoundException() {
        super("Patient not found");
    }
}
