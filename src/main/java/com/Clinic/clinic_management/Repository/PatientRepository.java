package com.Clinic.clinic_management.Repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Clinic.clinic_management.Models.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    
    List<Patient> findAllByOrderByFullNameAsc();

    
    List<Patient> findByFullNameContainingOrderByFullNameAsc(String fullName);
}