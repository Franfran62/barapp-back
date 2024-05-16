package com.barapp.barapp.Service.impl;

import com.barapp.barapp.Dto.UserLoginDto;
import com.barapp.barapp.Model.Entity.UserEntity;
import com.barapp.barapp.Model.Model.TokenStatus;
import com.barapp.barapp.Security.TokenGenerator;
import com.barapp.barapp.Service.IAuthService;
import com.barapp.barapp.Service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements IAuthService {
    @Autowired
    private TokenGenerator tokenGenerator;
    @Autowired
    private IUserService userService;

    @Override
    public String login(UserLoginDto userLoginDto) {

        if (userLoginDto == null) return null;
        UserEntity user = this.userService.checkCredentials(userLoginDto.getUsername(), userLoginDto.getPassword());
        if (user != null) {
            this.userService.updateLastConnection(user.getUsername());
            return this.tokenGenerator.generateToken(user);
        }

        return null;

    }
    @Override
    public String refreshToken(UserLoginDto userLoginDto, String token) {
        try {
            return switch (this.tokenGenerator.verifyToken(token)) {
                case Valid -> token;
                case Invalid, Expired -> {
                    UserEntity user = this.userService.checkCredentials(userLoginDto.getUsername(), userLoginDto.getPassword());
                    yield user != null ? this.tokenGenerator.generateToken(user) : null;
                }
                default -> null;
            };
        } catch (Exception e) {
            return null;
        }
    }
    @Override
    public TokenStatus verifyToken(String token) {
        return this.tokenGenerator.verifyToken(token);
    }
    @Override
    public String getUsernameFromtoken(String token) {
        return this.tokenGenerator.getUsernameFromtoken(token);
    }
}



