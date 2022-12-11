package com.example.studyapp;

import com.example.studyapp.Controllers.authController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.matchers.JUnitMatchers.containsString;
import static  org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import org.junit.matchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class integrationTesting {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private authController authController;

    @Test
    public void testRegController() throws Exception {
        this.mockMvc.perform(get("/regist"))
                .andExpect(content().string(containsString("add new user")));
    }

    @Test
    public void testLoginController() throws Exception {
        this.mockMvc.perform(get("/login"))
                .andExpect(content().string(containsString("Login:")));
    }
}
