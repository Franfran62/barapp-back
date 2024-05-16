package com.barapp.barapp.Service;

import com.barapp.barapp.Dto.UserCreateDto;
import com.barapp.barapp.Model.Entity.UserEntity;
import org.springframework.security.core.userdetails.User;

import java.util.Date;

public interface IUserService {

    public Boolean createUser(UserCreateDto user);
    public void updateLastConnection(String username);
    public UserEntity findByUsername(String username);
    public Date returnLastConnectionFromUsername(String username);
    public UserEntity checkCredentials(String username, String password);

}
