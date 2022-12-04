package com.example.studyapp.Controllers;

import com.example.studyapp.DB.Domain.GradeUntity;
import com.example.studyapp.DB.Domain.Role;
import com.example.studyapp.DB.Repo.GradeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
@PreAuthorize("hasAuthority('ADMIN')")
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

    @PostMapping("/addGrade")
    public String addGrade(  @RequestParam String Subject,
                             @RequestParam Integer Student,
                             @RequestParam Integer Grade,
                             @RequestParam String Comment,
                             Map<String,Object> model
    ) {
        System.out.printf(Subject, Student, Grade, Comment);
        GradeUntity GradeItem = new GradeUntity(Subject, Comment, Grade, Student);
        gradeRepo.save(GradeItem);
        Iterable<GradeUntity> list = gradeRepo.findAll();
        model.put("GradeList", list);
        return "grades";
    }
}
