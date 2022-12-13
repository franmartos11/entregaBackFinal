package com.example.proyect.service;

import com.example.proyect.exceptions.BadRequestException;
import com.example.proyect.exceptions.PatientNoContentException;
import com.example.proyect.exceptions.PatientNotFoundException;

import com.example.proyect.model.Patient;
import com.example.proyect.repository.PatientRepo;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@AllArgsConstructor
@Service
public class PatientService {

    private final PatientRepo repository;

    public List<Patient> getAll() throws PatientNoContentException {

        if(repository.findAll().isEmpty())
            throw new PatientNoContentException();
        return repository.findAll();

    }

    public Patient getById(Long id) throws PatientNotFoundException {

        return repository.findById(id).orElseThrow(PatientNotFoundException::new);

    }

    public Patient getByDni(String dni) throws PatientNotFoundException {

        return repository.findByDni(dni).orElseThrow(PatientNotFoundException::new);

    }

    public void create(Patient p) throws BadRequestException {

        if(repository.findByDni(p.getDni()).isPresent())
            throw new BadRequestException("Patient ' " + p.getLastName() +" " +p.getFirstName()+ " ' with dni: " + p.getDni() + " already exists in the data base");
        repository.save(p);

    }

    public void update(Patient p) throws PatientNotFoundException {

        if(repository.findById(p.getId()).isEmpty()) throw new PatientNotFoundException();
        repository.save(p);

    }

    public void deleteById(Long id) throws PatientNotFoundException {

        if(repository.findById(id).isEmpty()) throw new PatientNotFoundException();
        repository.deleteById(id);

    }

}

