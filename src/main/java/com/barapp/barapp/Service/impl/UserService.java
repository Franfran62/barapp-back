package com.barapp.barapp.Service.impl;

import com.barapp.barapp.Dto.UserCreateDto;
import com.barapp.barapp.Model.Entity.UserEntity;
import com.barapp.barapp.Repository.UserRepository;
import com.barapp.barapp.Service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Date;


@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Boolean createUser(UserCreateDto userCreateDto) {

        if (!this.dataIsConformed(userCreateDto) || this.userRepository.existsByUsername(userCreateDto.getUsername())) {
            throw new IllegalArgumentException("Impossible de créer ce nouvel utilisateur");
        }

        userCreateDto.setPassword(passwordEncoder.encode(userCreateDto.getPassword()));
        UserEntity user = new UserEntity();
        user.setUsername(userCreateDto.getUsername());
        user.setPassword(userCreateDto.getPassword());

        this.userRepository.save(user);

        return true;
    }

    @Override
    public UserEntity findByUsername(String username) {
        try {
            return this.userRepository.findByUsername(username);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Date returnLastConnectionFromUsername(String username) {
        UserEntity user = this.findByUsername(username);
        return user.getLastConnection();
    }

    public void updateLastConnection(String username) {
        UserEntity user = this.userRepository.findByUsername(username);
        user.setLastConnection(new Date());
        this.userRepository.save(user);
    }
    private Boolean dataIsConformed(UserCreateDto user) {

        if (user == null) {
            return false;
        }
        if (user.getUsername() == null ) {
            return false;
        }
        if (user.getPassword() == null || !this.isValidPassword(user.getPassword())) {
            return false;
        }

        return true;
    }

    private boolean isValidPassword(String password) {
        return password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,}$");
    }

    public UserEntity checkCredentials(String username, String password) {
        UserEntity user =  this.findByUsername(username);
        return user != null && passwordEncoder.matches(password, user.getPassword()) ? user : null;
    }
}


