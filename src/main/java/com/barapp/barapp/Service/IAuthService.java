package com.barapp.barapp.Service;

import com.barapp.barapp.Dto.UserLoginDto;
import com.barapp.barapp.Model.Model.TokenStatus;


public interface IAuthService {

    public String login(UserLoginDto userLoginDto);
    public String refreshToken(UserLoginDto userLoginDto, String token);
    public TokenStatus verifyToken(String token);
    public String getUsernameFromtoken(String username);
}
