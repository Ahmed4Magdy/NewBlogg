package com.example.Blogging.Service;

import com.example.Blogging.Dto.PostDto;
import com.example.Blogging.Dto.UserDto;
import com.example.Blogging.Entity.Post;
import com.example.Blogging.Entity.User;
import com.example.Blogging.Mapper.UserMapper;
import com.example.Blogging.Repository.UserRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;


    public ResponseEntity<?> findByid(Long id) {

        User userexit = userRepository.findById(id).orElseThrow();

        UserDto dto = userMapper.maptodto(userexit);

        return ResponseEntity.ok(dto);
    }


    public List<User> findAllUsers() {
        return userRepository.findAllUsers();
    }


    public ResponseEntity<?> update(UserDto userDto) {

       User user =userMapper.maptoentity(userDto);

       User saveuser =userRepository.save(user);

       UserDto userDto1 =userMapper.maptodto(saveuser);
       return ResponseEntity.ok(userDto1);


    }


    public ResponseEntity<?> findByEmail(@Valid String email) {

        User user= userRepository.findByEmail(email).orElseThrow();

        UserDto dto =userMapper.maptodto(user);

        return ResponseEntity.ok(dto);

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

        User user =userMapper.maptoentity(dto);
        User user1 =userRepository.save(user);

        UserDto userDto = userMapper.maptodto(user1);
        return ResponseEntity.ok(userDto);

    }


    public void deleteuser(Long id) {

        userRepository.deleteById(id);
    }


}
