package com.example.Blogging.Service;

import com.example.Blogging.Dto.PostDto;
import com.example.Blogging.Dto.UserDto;
import com.example.Blogging.Entity.Post;
import com.example.Blogging.Entity.User;
import com.example.Blogging.Repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
@Validated
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public ResponseEntity<?> findByid(Long id) {

        User userexit = userRepository.findById(id).orElseThrow();

        UserDto dto = new UserDto();
        dto.setFullname(userexit.getFullname());
        dto.setEmail(userexit.getEmail());
        return ResponseEntity.ok(dto);

//        return userRepository.findById(id).orElseThrow();
    }


    public List<User> findAllUsers() {
        return userRepository.findAllUsers();
    }


    public User update(User user) {


        User existuser = userRepository.findById(user.getId()).
                orElseThrow(() -> new RuntimeException("User not found"));


        existuser.setFullname(user.getFullname());
        existuser.setEmail(user.getEmail());
        existuser.setPassword(user.getPassword());
        return userRepository.save(existuser);

    }


    public Optional<User> findByEmail(@Valid String email) {

        return userRepository.findByEmail(email);

    }


    //Entity

//    public User Creatuser(User user) {
////        بتكون طريقه الربط بين اليوزر والبوست
//        for (Post post : user.getPosts()) {
//            post.setUser(user);
//        }
//
//        return userRepository.save(user);
//    }



    //Convert dto for entity and save entity and from entity for dto   as Manual 

    public ResponseEntity<?> createUser(UserDto dto) {

        // 1. Convert DTO → Entity
        User user = new User();
        user.setFullname(dto.getFullname());
        user.setEmail(dto.getEmail());

        // 2. Save entity to database ✅
        User savedUser = userRepository.save(user);

        // 3. Convert back to DTO if you want to return data (Optional)
        UserDto responseDto = new UserDto();
        responseDto.setFullname(savedUser.getFullname());
        responseDto.setEmail(savedUser.getEmail());

        // 4. Return response
        return ResponseEntity.ok(responseDto);
    }


    public void deleteuser(Long id) {

        userRepository.deleteById(id);
    }


}
