package com.Clinic.clinic_management.ServiceImpl;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.Clinic.clinic_management.Models.User;

public class CustomUserDetails implements UserDetails {

    private String name;
    private String password;

    public CustomUserDetails(User user) {

        this.name = user.getUserName();
        this.password = user.getUserPassword();

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.name;
    }


    
}
