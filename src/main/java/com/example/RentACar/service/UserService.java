package com.example.RentACar.service;

import com.example.RentACar.enumm.RoleEnum;
import com.example.RentACar.model.User;
import com.example.RentACar.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service

public class UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user){
        if (Objects.isNull(user.getRoles())){
            user.setRoles(RoleEnum.ROLE_USER.toString());
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

}
