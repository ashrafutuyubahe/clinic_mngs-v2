package com.Clinic.clinic_management.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Clinic.clinic_management.Models.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {
  // If you want all patients sorted by name, no parameter needed:
List<Patient> findAllByOrderByNameAsc();

// Or with filtering by fullName (assuming 'name' field), use:
List<Patient> findByNameContainingOrderByNameAsc(String fullName);

}
