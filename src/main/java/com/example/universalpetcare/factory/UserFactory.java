package com.example.universalpetcare.factory;

import com.example.universalpetcare.model.User;
import com.example.universalpetcare.request.RegistrationRequest;

public interface UserFactory {
    public User createUser(RegistrationRequest registrationRequest);
}
