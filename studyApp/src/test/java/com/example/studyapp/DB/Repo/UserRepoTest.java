package com.example.studyapp.DB.Repo;

import com.example.studyapp.DB.Domain.Role;
import com.example.studyapp.DB.Domain.UserEntity;
import com.example.studyapp.DB.Repo.UserRepo;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.util.Assert;
import org.junit.Assert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.Console;
import java.util.Iterator;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class UserRepoTest {

    @Autowired
    private UserRepo userRepo;

    @Test
    void failTestFindByLogin() {
        final String login = "puser";
        UserEntity user = userRepo.findByLogin(login);
        Assert.assertEquals(null, user);
    }

    @Test
    void successfulTestFindByLogin() {
        final String login = "puser";
        UserEntity user = userRepo.findByLogin(login);
        Assert.assertEquals("misha", user.getName());
    }

    @Test
    void successfulTestFindByUserRole() {
        Iterable<UserEntity> usersList = userRepo.findByRole(Role.USER);
        System.out.println(usersList);
        Assert.assertNotEquals(null, usersList);
    }

    @Test
    void successfulTestFindByAdminRole() {
        Iterable<UserEntity> usersList = userRepo.findByRole(Role.ADMIN);
        System.out.println(usersList);
        Assert.assertNotEquals(null, usersList);
    }
}