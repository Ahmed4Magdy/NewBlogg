package com.example.Blogging.Service;

import com.example.Blogging.Dto.LoginRequest;
import com.example.Blogging.Dto.PostDto;
import com.example.Blogging.Dto.UserDto;
import com.example.Blogging.Entity.Post;
import com.example.Blogging.Entity.User;
import com.example.Blogging.Mapper.UserMapper;
import com.example.Blogging.Repository.UserRepository;
import com.example.Blogging.Response.UserResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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




    public UserResponse Reigester (UserDto request) {

        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new RuntimeException("Email already exit");
        }

            User user = new User();
            user.setFullname(request.getFullname());
            user.setEmail(request.getEmail());
            user.setPassword(request.getPassword());
            User saved = userRepository.save(user);
            return mapToResponse(saved);


    }



    public UserResponse Login (LoginRequest request){

        User user =userRepository.findByEmail(request.getEmail()).
                orElseThrow(()-> new RuntimeException("Invalid email"));

        if(!request.getPassword().equals(user.getPassword())){
            throw new RuntimeException("Invalid  password");
        }

        return mapToResponse(user);

    }


    public UserResponse mapToResponse(User user) {
        UserResponse response = new UserResponse();

        response.setFullname(user.getFullname());
        response.setEmail(user.getEmail());
        return response;
    }


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



    public ResponseEntity<?> createUser(UserDto dto) {
        User user =userMapper.maptoentity(dto);

        for (Post post : user.getPosts()) {      //user.getposts() means get all posts that special with user
            post.setUser(user);                  //link all posts with link...put user for each post
        }
        User user1 =userRepository.save(user);
        UserDto userDto = userMapper.maptodto(user1);
        return ResponseEntity.ok(userDto);

    }


    public void deleteuser(Long id) {

        userRepository.deleteById(id);
    }

    @Transactional
    public void deleteByIdBetween(Long startId, Long endId){
        userRepository.deleteByIdBetween(startId,endId);
    }

}
