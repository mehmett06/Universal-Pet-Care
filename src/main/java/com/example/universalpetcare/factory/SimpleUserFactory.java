package com.example.universalpetcare.factory;

import com.example.universalpetcare.exception.USerAlreadyExistException;
import com.example.universalpetcare.model.User;
import com.example.universalpetcare.repository.UserRepository;
import com.example.universalpetcare.request.RegistrationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SimpleUserFactory implements UserFactory{
    private UserRepository userRepository;
    private final VeterinarianFactory veterinarianFactory;
    private final PatientFactory patientFactory;
    private final AdminFactory adminFactory;


    @Override
    public User createUser(RegistrationRequest registrationRequest) {
        if(userRepository.existyEmail(registrationRequest.getEmail())){
            throw new USerAlreadyExistException("!! Error"+registrationRequest.getEmail()+" already exist!!");
        }
        switch (registrationRequest.getUserType()){
            case "VET"->{return veterinarianFactory.createVeterinarian(registrationRequest);
          }
          case"PATIENT"->{ return patientFactory.createPatient(registrationRequest);
            }
            case"ADMIN"->{return adminFactory.createAdmin(registrationRequest);
            }
            default->{
                return null;
            }
        }

}}
