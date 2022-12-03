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
    private GradeRepo gradeRepo;

    @Autowired
    private UserRepo userRepo;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "main";
    }

    @GetMapping("/grade")
    public String index(Map<String, Object> model){
        model.put("GradeList", gradeRepo.findAll());
        model.put("users", userRepo.findAll());
        return "grade";
    }

    @PostMapping("/grade")
    public String indexPost(
            @RequestParam String Subject,
            @RequestParam Integer Student,
            @RequestParam Integer Grade,
            @RequestParam String Comment,
            Map<String,Object> model
    ){
        System.out.printf(Subject, Student, Grade, Comment);
        GradeUntity GradeItem = new GradeUntity(Subject,Comment,Grade, Student);
        gradeRepo.save(GradeItem);
        Iterable<GradeUntity> list = gradeRepo.findAll();
        model.put("GradeList", list);
        model.put("users", userRepo.findByRole(Role.USER));
        return "grade";
    }
    @PostMapping("/grades")
    public String grades(){
        return "grades";
    }
    @PostMapping("/findSubject")
    public String findSub(@RequestParam String subName, Map<String,Object> model){
        List<GradeUntity> grade = gradeRepo.findBySubject(subName);
        model.put("GradeList", grade);
        model.put("users", userRepo.findByRole(Role.USER));
        return "grade";
    }


    @PostMapping("/getUsers")
    public String getUsers(){
        return "users";
    }
}
