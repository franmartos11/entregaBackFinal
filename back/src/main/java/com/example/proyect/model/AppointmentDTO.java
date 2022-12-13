package com.example.proyect.model;
import java.time.LocalDateTime;

public record AppointmentDTO (long id, LocalDateTime ldt, Dentist d,Patient p){
}
