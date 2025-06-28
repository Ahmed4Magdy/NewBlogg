package com.example.Blogging.Dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDto {

//    private Long id;
    @Size(min = 2, max = 50, message = "fullname min 2 and max is 50 character")
    @NotBlank(message = "Full name is required")

    private String fullname;
    @NotBlank(message = "email is  required")
    @Email(message = "Invalid email format")
    private String email;


    private String password;


    private List<PostDto> posts;




}
//private PostDto postDto;