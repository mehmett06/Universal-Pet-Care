package com.example.universalpetcare.factory;

import com.example.universalpetcare.model.Patient;
import com.example.universalpetcare.model.User;
import com.example.universalpetcare.repository.PatientRepository;
import com.example.universalpetcare.request.RegistrationRequest;
import com.example.universalpetcare.service.user.UserAttributesMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientFactory {
    private final PatientRepository patientRepository;
    private final PatientFactory patientFactory;
    private final UserAttributesMapper userAttributesMapper;
    public Patient createPatient(RegistrationRequest request) {
        Patient patient=new Patient();
        userAttributesMapper.setCommonAttributes(request,patient);
        return patientRepository.save(patient);
    }
}
