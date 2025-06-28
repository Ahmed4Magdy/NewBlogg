package com.example.Blogging.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "User")
@Getter
@Setter
//@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Size(min = 2, max = 50, message = "fullname min 2 and max is 50 character")
    @NotBlank(message = "Full name is required")
    private String fullname;

    @NotBlank(message = "Full email is required")
    @Email(message = "Invalid email format")
    @Column(unique = true)
    private String email;

    @Size(min = 2, max = 20, message = "password must be at least 8 characters long.")
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
   private List<Post> posts;
}
