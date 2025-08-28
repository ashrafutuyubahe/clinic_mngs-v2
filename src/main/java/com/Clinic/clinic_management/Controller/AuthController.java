package com.Clinic.clinic_management.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import com.Clinic.clinic_management.Dto.LoginDto;
import com.Clinic.clinic_management.Dto.LoginResponseDto;
import com.Clinic.clinic_management.Dto.RegisterDto;

import com.Clinic.clinic_management.ServiceImpl.AuthServiceImpl;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("clinic-mngs-v2/api/v1/auth")
public class AuthController {

    private final AuthServiceImpl authServiceImpl;

    @Autowired
    public AuthController(AuthServiceImpl authServiceImpl) {
        this.authServiceImpl = authServiceImpl;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody RegisterDto registerDto) {
        String response = authServiceImpl.registerUser(registerDto);
        System.out.println(registerDto);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginDto loginDto) {
        LoginResponseDto response = authServiceImpl.loginUser(loginDto);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/welcome")
    public ResponseEntity<String> welcome() {
        return ResponseEntity.ok("This is not protected");
    }
}
