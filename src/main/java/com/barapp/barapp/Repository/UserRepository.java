package com.barapp.barapp.Repository;

import com.barapp.barapp.Model.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository  extends JpaRepository<UserEntity, Byte> {

    Boolean existsByUsername(String username);
    UserEntity findByUsername(String username);

}
