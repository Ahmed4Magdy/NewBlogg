package com.example.Blogging.Controller;


import com.example.Blogging.Entity.Post;
import com.example.Blogging.Repository.PostRepository;
import com.example.Blogging.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {


    @Autowired
    private PostService postService;


//    @GetMapping("/{id}")
//    public Post findByid(@PathVariable Long id) {
//
//        return postService.findByid(id);
//    }




    @GetMapping("/{id}")
    public ResponseEntity<?> findByid(@PathVariable Long id) {

        return ResponseEntity.ok(postService.findByid(id));
    }


    @GetMapping
    public List<Post> findAllposts() {
        return postService.findAllposts();
    }


//    @PutMapping("/")
//    public Post update(@RequestBody Post post) {
//
//        return postService.update(post);
//
//    }


    @PutMapping("/")
    public ResponseEntity<?> update(@RequestBody Post post) {

        return ResponseEntity.ok(postService.update(post));

    }


    @PostMapping("/add/")
    public Post insert(@RequestBody Post post) {
        return postService.insert(post);
    }



    @DeleteMapping("/range")
    public void deleteByIdBetween(@RequestParam Long startId,@RequestParam Long endId){
        postService.deleteByIdBetween(startId,endId);
    }

}
