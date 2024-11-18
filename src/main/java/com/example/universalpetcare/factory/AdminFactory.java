package com.example.universalpetcare.factory;

import com.example.universalpetcare.model.Admin;
import com.example.universalpetcare.model.User;
import com.example.universalpetcare.repository.AdminRepository;
import com.example.universalpetcare.request.RegistrationRequest;
import com.example.universalpetcare.service.user.UserAttributesMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminFactory {
    private final AdminRepository adminRepository;
    private final UserAttributesMapper userAttributesMapper;
    public Admin createAdmin(RegistrationRequest request) {
        Admin admin=new Admin();
        userAttributesMapper.setCommonAttributes(request,admin);
        return adminRepository.save(admin);
    }
}
