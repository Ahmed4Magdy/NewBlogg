package com.example.Blogging.Dto;

import jakarta.validation.constraints.Size;

public class PostDto {


    @Size(max = 50, message = "title is max 50 charachter")
    private String title;

    @Size(max = 50, message = "content is max 50 character")
    private String content;


    private UserDto userDto;

}
