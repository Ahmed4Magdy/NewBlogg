package com.example.Blogging.Controller;

import com.example.Blogging.Dto.LoginRequest;
import com.example.Blogging.Dto.UserDto;
import com.example.Blogging.Entity.Post;
import com.example.Blogging.Entity.User;
import com.example.Blogging.Repository.UserRepository;
import com.example.Blogging.Response.UserResponse;
import com.example.Blogging.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
//@Validated
@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;




    @PostMapping("/register")
    public ResponseEntity<?> Reigester (@RequestBody UserDto request) {
        return ResponseEntity.ok(userService.Reigester(request));
    }



    @PostMapping("/login")
    public ResponseEntity<UserResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(userService.Login(request));
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> findByid(@PathVariable Long id) {
        return userService.findByid(id);
    }

    @GetMapping
    public List<User> findAllUsers() {
        return userService.findAllUsers();
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody UserDto userdto) {
        return ResponseEntity.ok(userService.update(userdto));
    }


    @GetMapping("/email")
    public ResponseEntity<?> findByEmail(@RequestParam String email) {

        return ResponseEntity.ok(userService.findByEmail(email));

    }


//    @PostMapping("/add/")
//    public User Creatuser(@RequestBody User user) {
//
//        return userService.Creatuser(user);
//    }

    @PostMapping("/add/")
    public ResponseEntity<?> Creatuser(@Valid @RequestBody UserDto userDto) {

        return ResponseEntity.ok(userService.createUser(userDto));
    }


    @DeleteMapping("/{id}")
    public void deleteuser(@PathVariable Long id) {

        userService.deleteuser(id);
    }


    @DeleteMapping("/range")
    public void deleteByIdBetween(@RequestParam Long startId,@RequestParam Long endId){
        userService.deleteByIdBetween(startId,endId);
    }


}
