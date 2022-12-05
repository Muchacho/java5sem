package com.example.studyapp.Controllers;

import com.example.studyapp.DB.Domain.GradeUntity;
import com.example.studyapp.DB.Domain.Role;
import com.example.studyapp.DB.Repo.GradeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public String addGrade(  @Valid GradeUntity grade,
                             BindingResult bindingResult,
                             Model model
    ) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errors = ControllerUtils.getErrors(bindingResult);
            System.out.println(errors);
            model.mergeAttributes(errors);
            Iterable<GradeUntity> list = gradeRepo.findAll();
            model.addAttribute("GradeList", list);
            return "grades";
        }
        gradeRepo.save(grade);
        Iterable<GradeUntity> list = gradeRepo.findAll();
        model.addAttribute("GradeList", list);
        return "grades";
    }
}
