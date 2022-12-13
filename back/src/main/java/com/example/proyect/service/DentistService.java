package com.example.proyect.service;

import com.example.proyect.exception.BadRequestException;
import com.example.proyect.exception.DentistNoContException;
import com.example.proyect.exception.DentistNotFoundException;

import com.example.proyect.model.Dentist;
import com.example.proyect.repository.DentistRepo;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class DentistService {

    private final DentistRepo repository;

    public List<Dentist> getAll() throws DentistNoContException {

        if(repository.findAll().isEmpty())
            throw new DentistNoContException();
        return repository.findAll();

    }

    public Dentist getById(Long id) throws DentistNotFoundException {
        return repository.findById(id).orElseThrow(DentistNotFoundException::new);

    }

    public Dentist getByMedicalLicense(String ml) throws DentistNotFoundException {
        return repository.findByMedicalLicense(ml).orElseThrow(DentistNotFoundException::new);

    }

    public void create(Dentist d) throws BadRequestException {

        if(repository.findByMedicalLicense(d.getMedicalLicense()).isPresent())
            throw new BadRequestException("Already Exist a Dentist With the Medical License : " + d.getMedicalLicense() + " on the data base");
        repository.save(d);

    }

    public void update(Dentist d) throws DentistNotFoundException {

        if (repository.findById(d.getId()).isEmpty())
            throw new DentistNotFoundException();
        repository.save(d);

    }

    public void deleteById(Long id) throws BadRequestException {

        if (repository.findById(id).isEmpty())
            throw new BadRequestException(" Doesnt seem to exist a dentist with the medical License" + id + " in the data base");
        repository.deleteById(id);

    }

}
