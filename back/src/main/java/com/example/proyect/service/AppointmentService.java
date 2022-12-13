package com.example.proyect.service;

import com.example.proyect.exceptions.AppNoContException;
import com.example.proyect.exceptions.AppNotFoundException;

import com.example.proyect.model.Appointment;
import com.example.proyect.model.AppointmentDTO;

import com.example.proyect.repository.AppointmentRepo;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@Service
public class AppointmentService {

    private final AppointmentRepo repository;
    ObjectMapper mapper;

    public Set<AppointmentDTO> getAll() throws AppNoContException {

        var appointmentList = repository.findAll();

        if(appointmentList.isEmpty())
            throw new AppNoContException();

        Set<AppointmentDTO> DTOList = new HashSet<>();
        for (Appointment appointment: appointmentList){

            if (mapper != null)
                DTOList.add(mapper.convertValue(appointment,AppointmentDTO.class));
        }
        return DTOList;

    }

    public AppointmentDTO getById(Long id) throws AppNotFoundException {
        var optional = repository.findById(id);

        if (optional.isEmpty())
            throw new AppNotFoundException();

        if (mapper != null)
            return mapper.convertValue(optional,AppointmentDTO.class);

        return null;

    }

    private void save(AppointmentDTO dto) {

        Appointment a = null;
        if (mapper != null)
            a = mapper.convertValue(dto,Appointment.class);
        repository.save(a);

    }

    public void create(AppointmentDTO dto) {
        save(dto);
    }

    public void update(AppointmentDTO dto) throws AppNotFoundException {

        if (repository.findById(dto.id()).isEmpty())
            throw new AppNotFoundException();
        save(dto);

    }

    public void deleteById(Long id) throws AppNotFoundException {

        if (repository.findById(id).isEmpty())
            throw new AppNotFoundException();
        repository.deleteById(id);

    }

}
