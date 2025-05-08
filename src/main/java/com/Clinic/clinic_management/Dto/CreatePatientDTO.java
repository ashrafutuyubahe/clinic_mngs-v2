package com.Clinic.clinic_management.Dto;
import lombok.Data;


@Data
public class CreatePatientDTO {
    private String fullName;
    private int age;
    private String gender;
    private String phone;
    private String email;
    private String address;
    private String disease;
    private String medication;
}
