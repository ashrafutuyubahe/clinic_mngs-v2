package com.Clinic.clinic_management.Models;


import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails.Address;

import com.Clinic.clinic_management.classes.ResetToken;

import jakarta.persistence.Column;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;




@Entity
@Table(name = "users", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"user_email", "user_phone"})
})

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User  {
   
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long  userId;

@NotBlank(message = "user name is required")
@Column(name = "user_name",length = 255,nullable = false)
private String userName;


@NotBlank(message = "user email is required")
@Column(name = "user_email",length = 255,nullable = false)
@Email(message = "must me email")
private String userEmail;

@NotBlank(message = "user password is required")
@Column(name = "user_password",length = 255,nullable = false)
private String userPassword;

@NotBlank(message = "user phone is required")
@Column(name = "user_phone", length = 255, nullable = false)
private String userPhone;


@Embedded
private Address address;

// @Embedded
// private Contact contact;

@Embedded 
private ResetToken resetToken;




public void createResetToken(String token) {
    if (resetToken == null) {
        resetToken = new ResetToken();
    }
    resetToken.generateResetToken(token, 1);
}

public boolean isResetTokenValid(String token) {
    return resetToken != null && resetToken.getToken().equals(token) && !resetToken.isExpired();
}

public void clearResetToken() {
    if (resetToken != null) {
        resetToken.clearToken();
    }
}

    
}
