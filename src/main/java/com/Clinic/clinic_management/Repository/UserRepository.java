package com.Clinic.clinic_management.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Clinic.clinic_management.Models.User;




@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserName(String userName);
    Optional<User> findByUserEmail(String userEmail);
    Optional<User>  findByResetToken(String token);

}

