package com.Clinic.clinic_management.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Clinic.clinic_management.Models.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
