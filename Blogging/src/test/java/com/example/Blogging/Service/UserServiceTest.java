package com.example.Blogging.Service;

import com.example.Blogging.Dto.UserDto;
import com.example.Blogging.Entity.User;
import com.example.Blogging.Mapper.UserMapper;
import com.example.Blogging.Repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
@ExtendWith(MockitoExtension.class)

public class UserServiceTest {


    @Mock
    private UserRepository userRepository;

    @Mock
    private UserMapper userMapper;

    @InjectMocks
    private UserService userService;

    @Test
    public void FindEmailFound() {


        Optional<User> existuser = Optional.of(new User(null, "norieen", "noror@gmail.com", "nor@fewon", null));
        UserDto userdto = new UserDto("norieen", "noror@gmail.com", "nor@fewon", null);

        Mockito.when(userRepository.findByEmail("ahmed@gmail.com")).thenReturn(existuser);
        Mockito.when(userMapper.maptodto(existuser.get())).thenReturn(userdto);

        //return dto
        ResponseEntity<?> response = userService.findByEmail("ahmed@gmail.com");

        // the two is correct and
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(userdto,response.getBody());


//        verify(userRepository, times(1)).findByEmail("ahmed@gmail.com");
//        verify(userMapper, times(1)).maptodto(existuser.get());

    }


}
