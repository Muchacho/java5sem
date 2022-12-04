package com.example.studyapp.Controllers;

import com.example.studyapp.DB.Domain.GradeUntity;
import com.example.studyapp.DB.Domain.Role;
import com.example.studyapp.DB.Repo.GradeRepo;
import com.example.studyapp.DB.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class MainController {
    @Autowired
    private UserRepo userRepo;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        model.put("users", userRepo.findByRole(Role.USER));
        return "main";
    }

    @PostMapping("/getUsers")
    public String getUsers(){
        return "users";
    }
}
