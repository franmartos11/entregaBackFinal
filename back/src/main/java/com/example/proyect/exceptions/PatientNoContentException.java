package com.example.proyect.exceptions;

public class PatientNoContentException extends Exception{
    public PatientNoContentException() {
        super("There arent patients on the data base");
    }
}
