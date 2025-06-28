package com.example.Blogging.Dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class PostDto {


    private Long id;

    @Size(max = 50, message = "title is max 50 charachter")
    private String title;

    @Size(max = 50, message = "content is max 50 character")
    private String content;

    @JsonIgnore
    private UserDto userDto;

}
