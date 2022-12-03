package com.example.studyapp.Controllers;

import com.example.studyapp.DB.Domain.GradeUntity;
import com.example.studyapp.DB.Domain.Role;
import com.example.studyapp.DB.Repo.GradeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class GradeController {

    @Autowired
    private GradeRepo gradeRepo;

    @GetMapping("/getGrades")
    public String getGrades(Map<String, Object> model){
        model.put("GradeList", gradeRepo.findAll());
        return "grades";
    }

    @PostMapping("/findGrades")
    public String findGrades(@RequestParam String subject, Map<String, Object> model){
        model.put("GradeList", gradeRepo.findBySubject(subject));
        return "grades";
    }
}
