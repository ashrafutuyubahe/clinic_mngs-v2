package com.Clinic.clinic_management.Controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.Clinic.clinic_management.Dto.CreatePatientDTO;
import com.Clinic.clinic_management.Dto.UpdatePatientDTO;
import com.Clinic.clinic_management.Models.Patient;
import com.Clinic.clinic_management.Service.PatientService;
import java.util.List;

@RestController
@RequestMapping("clinic-mngs-v2/api/v1/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping("/create-patient")
    public Patient createPatient(@RequestBody CreatePatientDTO dto) {
        return patientService.createPatient(dto);
    }

    @GetMapping("/get-single/{id}")
    public Patient getPatientById(@PathVariable Long id) {
        return patientService.getPatientById(id);
    }

    @GetMapping("/get-all")
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    @PutMapping("update-patient/{id}")
    public Patient updatePatient(@PathVariable Long id, @RequestBody UpdatePatientDTO dto) {
        return patientService.updatePatient(id, dto);
    }

    @DeleteMapping("remove-patient/{id}")
    public String deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
        return "Patient with ID " + id + " deleted successfully.";
    }

    @GetMapping("/get-all-Paginated")
    public Page<Patient> getAllPatients(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "2") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        return patientService.getAllPatientsPaginated(pageable);
    }

    @GetMapping("/sorted-by-name")
    public ResponseEntity<List<Patient>> getAllSortedByName(
            @RequestParam(defaultValue = "asc") String sortDir) {
        List<Patient> sortedPatients = patientService.getAllPatientSortedByName(sortDir);
        return ResponseEntity.ok(sortedPatients);
    }
}