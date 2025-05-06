package com.Clinic.clinic_management.Dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
@Setter
@Getter
public class UpdateUserDto {

    @NotBlank(message = "user name is required")
    @Column(name = "user_name", length = 255, nullable = false)
    private String userName;

    @NotBlank(message = "user email is required")
    @Column(name = "user_email", length = 255, nullable = false)
    @Email(message = "must me email")
    private String userEmail;

    @NotBlank(message = "user password is required")
    @Column(name = "user_password", length = 255, nullable = false)
    private String userPassword;

    @NotBlank(message = "user phone is required")
    @Column(name = "user_phone", length = 255, nullable = false)
    private String userPhone;

}
