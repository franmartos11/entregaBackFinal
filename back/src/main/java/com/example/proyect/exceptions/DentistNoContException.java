package com.example.proyect.exceptions;

public class DentistNoContException extends Exception{
    public DentistNoContException() {
        super("There arent Dentist on data base");
    }
}
