package com.Clinic.clinic_management.Service;



import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Clinic.clinic_management.Dto.CreatePatientDTO;
import com.Clinic.clinic_management.Dto.UpdatePatientDTO;
import com.Clinic.clinic_management.Models.Patient;

public interface PatientService {
    Patient createPatient(CreatePatientDTO dto);
    Patient getPatientById(Long id);
    List<Patient> getAllPatients();
    Patient updatePatient(Long id, UpdatePatientDTO dto);
    void deletePatient(Long id);
    Page<Patient> getAllPatientsPaginated(Pageable pageable);
    
   
    List<Patient> getAllPatientSortedByName(String fullName);

}
