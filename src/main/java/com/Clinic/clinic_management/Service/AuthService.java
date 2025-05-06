package com.Clinic.clinic_management.Service;

import com.Clinic.clinic_management.Dto.LoginDto;
import com.Clinic.clinic_management.Dto.LoginResponseDto;
import com.Clinic.clinic_management.Dto.RegisterDto;

public interface AuthService {
    String registerUser(RegisterDto registerDto);
    LoginResponseDto loginUser(LoginDto loginDto);
    String logoutrUser();
    void requestPasswordReset(String email);
    boolean verifyResetCode(String email, String code);
    void resetPassword(String email, String newPassword);
}
