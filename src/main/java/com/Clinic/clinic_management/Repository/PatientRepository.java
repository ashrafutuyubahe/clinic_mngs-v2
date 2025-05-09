package com.Clinic.clinic_management.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Clinic.clinic_management.Models.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {
      @Query("SELECT Patient FROM  Patient WHERE s.fullName = :fullName")
    List<Patient> getAllPatientSortedByName(@Param("fullName") String fullName);

}
