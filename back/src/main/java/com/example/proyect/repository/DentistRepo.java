package com.example.proyect.repository;

import com.example.proyect.model.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DentistRepo extends JpaRepository<Dentist,Long> {

    @Query("select d from Dentist d where d.medicalLicense = ?1")
    Optional<Dentist> findByMedicalLicense(String medicalLicense);

}
