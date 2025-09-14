package com.example.Blogging.Controller;

import com.example.Blogging.Dto.UserDto;
import com.example.Blogging.Service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
@ActiveProfiles("test")

public class UserControllerTest {

    @MockBean
    private UserService userService;

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void findByEmail() throws Exception {


        UserDto userdto = new UserDto("norieen", "noror@gmail.com", "nor@fewon", null);


        Mockito.<ResponseEntity<?>>when(userService.createUser(Mockito.any(UserDto.class)))
                .thenReturn(ResponseEntity.ok(userdto));



        String userJson = """
            {
                "fullName": "norieen",
                "email": "noror@gmail.com",
                "password": "nor@fewon",
                "posts": null
            }
        """;

        mockMvc.perform(post("/user/add/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(userJson))
                .andExpect(status().isOk());


    }



    }



