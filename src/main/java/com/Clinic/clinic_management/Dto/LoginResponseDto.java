package com.Clinic.clinic_management.Dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseDto {
    private String token;
    private String userName;
    private String userEmail;
    private String message;
    private Long userId;


   
    
}
