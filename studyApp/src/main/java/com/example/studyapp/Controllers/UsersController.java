package com.example.studyapp.Controllers;

import com.example.studyapp.DB.Domain.GradeUntity;
import com.example.studyapp.DB.Domain.Role;
import com.example.studyapp.DB.Domain.UserEntity;
import com.example.studyapp.DB.Repo.GradeRepo;
import com.example.studyapp.DB.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class UsersController {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private GradeRepo gradeRepo;

    @GetMapping("/getUsers")
    public String getUsers(Map<String, Object> model){
        model.put("GradesList", gradeRepo.findAll());
        return "users";
    }


    @PostMapping("/findUsers")
    public String findUsers(@RequestParam Integer id, Map<String, Object> model){
        List<GradeUntity> gradesList = gradeRepo.findByStudent(id);
        //UserEntity user = userRepo.findByLogin(login);
       // List<UserEntity> users = new ArrayList<>();
       // users.add(user);
        model.put("GradesList", gradesList);
        return "users";
    }
}
