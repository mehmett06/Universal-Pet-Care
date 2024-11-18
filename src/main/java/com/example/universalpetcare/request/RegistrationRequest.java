package com.example.universalpetcare.request;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class RegistrationRequest {
    private Long id ;
    private String firstName;
    private String lastName;
    private String gender;
    @Column(name = "mobile")
    private String phoneNumber;
    private String email;
    private String password;
    private String userType;
    private boolean isEnabled;
    private String specialization;
}
