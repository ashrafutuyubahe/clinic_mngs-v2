package com.Clinic.clinic_management.ServiceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import com.Clinic.clinic_management.Dto.CreatePatientDTO;
import com.Clinic.clinic_management.Dto.UpdatePatientDTO;
import com.Clinic.clinic_management.Models.Patient;
import com.Clinic.clinic_management.Repository.PatientRepository;
import com.Clinic.clinic_management.Service.PatientService;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public Patient createPatient(CreatePatientDTO dto) {
        Patient patient = Patient.builder()
                .fullName(dto.getFullName())
                .age(dto.getAge())
                .gender(dto.getGender())
                .phone(dto.getPhone())
                .email(dto.getEmail())
                .address(dto.getAddress())
                .disease(dto.getDisease())
                .medication(dto.getMedication())
                .build();

        return patientRepository.save(patient);
    }

    @Override
    public Patient getPatientById(Long id) {
        return patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found"));
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    public Patient updatePatient(Long id, UpdatePatientDTO dto) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Patient not found"));

        patient.setFullName(dto.getFullName());
        patient.setAge(dto.getAge());
        patient.setGender(dto.getGender());
        patient.setPhone(dto.getPhone());
        patient.setEmail(dto.getEmail());
        patient.setAddress(dto.getAddress());
        patient.setDisease(dto.getDisease());
        patient.setMedication(dto.getMedication());

        return patientRepository.save(patient);
    }

    @Override
    public void deletePatient(Long id) {
        if (!patientRepository.existsById(id)) {
            throw new RuntimeException("Patient not found");
        }
        patientRepository.deleteById(id);
    }

    @Override
    public Page<Patient> getAllPatients(Pageable pageable) {
        return patientRepository.findAll(pageable);
    }

    public List<Patient> getAllPatientySortedByName(String sortDir) {
        
        Sort sort = sortDir.equalsIgnoreCase("desc") ?
                    Sort.by("patientName").descending() :
                    Sort.by("patientName").ascending();
    
        return patientRepository.findAll(sort);
    }

}
