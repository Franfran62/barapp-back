package com.barapp.barapp.Controller.Security;

import com.barapp.barapp.Dto.UserCreateDto;
import com.barapp.barapp.Service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

    @Autowired
    private IUserService userService;

    @PutMapping("/create")
    public ResponseEntity<String> createUser(@RequestBody UserCreateDto userDto) {
        try {
            userService.createUser(userDto);
            return ResponseEntity.status(HttpStatus.CREATED).body("Création réussi");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Impossible de créer un utilisateur");
        }
    }
}
