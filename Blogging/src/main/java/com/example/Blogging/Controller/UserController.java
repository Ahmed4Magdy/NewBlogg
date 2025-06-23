package com.example.Blogging.Controller;

import com.example.Blogging.Dto.UserDto;
import com.example.Blogging.Entity.Post;
import com.example.Blogging.Entity.User;
import com.example.Blogging.Repository.UserRepository;
import com.example.Blogging.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {


    @Autowired
    private UserService userService;


    @GetMapping("/{id}")
    public ResponseEntity<?> findByid(@PathVariable Long id) {
        return userService.findByid(id);
    }

    @GetMapping
    public List<User> findAllUsers() {
        return userService.findAllUsers();
    }

    @PutMapping
    public User update(@RequestBody User user) {
        return userService.update(user);
    }


    @GetMapping("/email")
    public Optional<User> findByEmail(@RequestParam String email) {

        return userService.findByEmail(email);

    }


//    @PostMapping("/add/")
//    public User Creatuser(@RequestBody User user) {
//
//        return userService.createUser(user);
//    }

    @PostMapping("/add/")
    public ResponseEntity<?> Creatuser(@RequestBody UserDto userDto) {

        return ResponseEntity.ok(userService.createUser(userDto));
    }


    @DeleteMapping("/{id}")
    public void deleteuser(@PathVariable Long id) {

        userService.deleteuser(id);
    }

}
