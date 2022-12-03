package com.example.studyapp.Controllers;

import com.example.studyapp.DB.Domain.Role;
import com.example.studyapp.DB.Domain.UserEntity;
import com.example.studyapp.DB.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
            @RequestParam String username,
            @RequestParam String course,
            @RequestParam String login,
            @RequestParam String password,
            Map<String, Object> model) {

        UserEntity User = users.findByLogin(login);
        if(User != null){
            model.put("message", "user exist");
            return "regist";
        }
        UserEntity newUser = new UserEntity(username, course, login, password);
        newUser.setActive(true);
        newUser.setRole(Collections.singleton(Role.USER));
        users.save(newUser);

        return "redirect:/login";
    }
}
