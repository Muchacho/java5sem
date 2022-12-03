package com.example.studyapp.DB.Repo;


import com.example.studyapp.DB.Domain.Role;
import com.example.studyapp.DB.Domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<UserEntity, Integer> {
    UserEntity findByLogin(String login);

//    UserEntity findById(Integer id);
    Iterable<UserEntity> findByRole(Role role);

}
