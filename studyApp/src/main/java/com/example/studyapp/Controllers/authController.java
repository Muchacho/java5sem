package com.example.studyapp.Controllers;

import com.example.studyapp.DB.Domain.Role;
import com.example.studyapp.DB.Domain.UserEntity;
import com.example.studyapp.DB.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.Collections;
import java.util.Map;

@Controller
public class authController {
    @Autowired
    private UserRepo users;
    @GetMapping("/regist")
    public String regist(){
        return "regist";
    }

    @PostMapping("/regist")
    public String postRegistr(
            @Valid UserEntity user,
            BindingResult bindingResult,
            Model model) {

        if (bindingResult.hasErrors()) {
            Map<String, String> errors = ControllerUtils.getErrors(bindingResult);
            System.out.println(errors);
            model.mergeAttributes(errors);

            return "regist";
        }
        UserEntity User = users.findByLogin(user.getLogin());
        if(User != null){
            model.addAttribute("message", "user exist");
            return "regist";
        }
//        UserEntity newUser = new UserEntity(username, course, login, password);
        user.setActive(true);
        user.setRole(Collections.singleton(Role.USER));
        users.save(user);

        return "redirect:/login";
    }
}
