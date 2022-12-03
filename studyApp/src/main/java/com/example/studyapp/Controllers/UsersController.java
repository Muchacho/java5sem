package com.example.studyapp.Controllers;

import com.example.studyapp.DB.Domain.Role;
import com.example.studyapp.DB.Domain.UserEntity;
import com.example.studyapp.DB.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class UsersController {
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/getUsers")
    public String getUsers(Map<String, Object> model){
        model.put("users", userRepo.findAll());
        return "users";
    }


    @PostMapping("/findUsers")
    public String findUsers(@RequestParam String login, Map<String, Object> model){
         model.put("users", userRepo.findByLogin(login));
        return "users";
    }
}
