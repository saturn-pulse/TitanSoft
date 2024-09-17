package com.saturnpulse.titan.Controller;

import com.saturnpulse.titan.Entity.Admin;
import com.saturnpulse.titan.Model.MyAppUser;
import com.saturnpulse.titan.Model.MyAppUserRepository;
import com.saturnpulse.titan.Repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    @Autowired
    private MyAppUserRepository myAppUserRepository;

    @Autowired
    private AdminRepository adminRepository;

//    @Autowired
//    private PasswordEncoder passwordEncoder;



    @PostMapping(value = "/req/signup", consumes = "application/json")
    public Admin createUser(@RequestBody Admin admin) {
//        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        return adminRepository.save(admin);
    }

}
