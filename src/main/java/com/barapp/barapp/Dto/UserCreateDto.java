package com.barapp.barapp.Dto;

import lombok.Data;

@Data
public class UserCreateDto  {

    private String username;
    private String password;

    @Override
    public String toString() {
        return "user="+this.username+".";
    }
}
