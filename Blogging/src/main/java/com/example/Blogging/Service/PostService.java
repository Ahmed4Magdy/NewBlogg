package com.example.Blogging.Service;

import com.example.Blogging.Dto.PostDto;
import com.example.Blogging.Entity.Post;
import com.example.Blogging.Entity.User;
import com.example.Blogging.Mapper.PostMapper;
import com.example.Blogging.Repository.PostRepository;
import com.example.Blogging.Repository.UserRepository;
import jakarta.persistence.Entity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {


    private final PostRepository postRepository;

    private final UserRepository userRepository;

    private final PostMapper postMapper;


//    public Post findByid(Long id) {
//
//        return postRepository.findById(id).get();
//    }


    public ResponseEntity<?> findByid(Long id) {

        Post post = postRepository.findById(id).orElseThrow();

        PostDto postDto = postMapper.maptodto(post);

        return ResponseEntity.ok(postDto);

    }


    public List<Post> findAllposts() {
        return postRepository.findAll();
    }


//    public Post update(Post post) {
//
//        Post existuser = postRepository.findById(post.getId()).get();
//
//        existuser.setContent(post.getContent());
//        existuser.setTitle(post.getTitle());
//        existuser.setUpdatedAt(post.getUpdatedAt());
//        existuser.setCreatedAt(post.getCreatedAt());
//        return postRepository.save(existuser);
//
//    }


    public ResponseEntity<?> update(Post post) {

        Post existuser = postRepository.findById(post.getId()).get();
        existuser.setTitle(post.getTitle());
        existuser.setContent(post.getContent());
        PostDto postDto = postMapper.maptodto(existuser);
        return ResponseEntity.ok(postDto);

    }


    public Post insert(Post post) {


        return postRepository.save(post);
    }



    @Transactional
    public void deleteByIdBetween(Long startId, Long endId){
        postRepository.deleteByIdBetween(startId,endId);
    }



}
