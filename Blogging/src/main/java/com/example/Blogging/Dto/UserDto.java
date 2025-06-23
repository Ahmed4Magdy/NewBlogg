package com.example.Blogging.Dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {


    @Size(min = 2, max = 50, message = "fullname min 2 and max is 50 character")
    private String fullname;
    @Email(message = "Invalid email format")
    @Column(unique = true)
    private String email;




    @JsonIgnore
    private PostDto postDto;




}
