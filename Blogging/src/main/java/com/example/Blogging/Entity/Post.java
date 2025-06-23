package com.example.Blogging.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Table(name = "post")
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 50, message = "title is max 50 charachter")
    private String title;

    @Size(max = 50, message = "content is max 50 character")
    private String content;

    @CreatedDate
    private LocalDateTime createdAt;
    @LastModifiedDate
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private User user;
}
