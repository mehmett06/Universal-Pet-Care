package com.example.universalpetcare.factory;

import com.example.universalpetcare.model.User;
import com.example.universalpetcare.model.Veterinarian;
import com.example.universalpetcare.repository.UserRepository;
import com.example.universalpetcare.repository.VeterinarianRepository;
import com.example.universalpetcare.request.RegistrationRequest;
import com.example.universalpetcare.service.user.UserAttributesMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VeterinarianFactory {
    private final VeterinarianRepository veterinarianRepository;
    private final UserAttributesMapper userAttributesMapper;

    public Veterinarian createVeterinarian(RegistrationRequest request) {
        Veterinarian veterinarian=new Veterinarian();
        userAttributesMapper.setCommonAttributes(request,veterinarian);
        veterinarian.setSpecialization(request.getSpecialization());

        return veterinarianRepository.save(veterinarian);
    }
}
