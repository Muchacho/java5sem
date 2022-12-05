package com.example.studyapp.Controllers;

import com.example.studyapp.DB.Domain.GradeUntity;
import com.example.studyapp.DB.Domain.Role;
import com.example.studyapp.DB.Domain.UserEntity;
import com.example.studyapp.DB.Repo.GradeRepo;
import com.example.studyapp.DB.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String findUsers(UserEntity user, Model model){
        List<GradeUntity> gradesList = gradeRepo.findByStudent(user.getId());
        if(user.getId() == null){
            System.out.println("no id");
            model.addAttribute("error", "Wrong id");
            model.addAttribute("GradesList",gradeRepo.findAll());
            return "users";
        }
        else if(gradesList.isEmpty()){
            System.out.println("user not exist");
            model.addAttribute("error", "Student not exist");
            model.addAttribute("GradesList",gradeRepo.findAll());
            return "users";
        }
        model.addAttribute("GradesList", gradesList);
        return "users";
    }
}
