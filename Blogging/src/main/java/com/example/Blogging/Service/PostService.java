package com.example.Blogging.Service;

import com.example.Blogging.Entity.Post;
import com.example.Blogging.Entity.User;
import com.example.Blogging.Repository.PostRepository;
import com.example.Blogging.Repository.UserRepository;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {


    @Autowired
    private PostRepository postRepository;

    @Autowired
    private UserRepository userRepo;


    public Post findByid(Long id) {

        return postRepository.findById(id).get();
    }


    public List<Post> findAllposts() {
        return postRepository.findAll();
    }


    public Post update(Post post) {

        Post existuser = postRepository.findById(post.getId()).get();

        existuser.setContent(post.getContent());
        existuser.setTitle(post.getTitle());
        existuser.setUpdatedAt(post.getUpdatedAt());
        existuser.setCreatedAt(post.getCreatedAt());
        return postRepository.save(existuser);

    }


    public Post insert(Post post) {


        return postRepository.save(post);
    }


}
