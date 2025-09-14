package com.example.Blogging.Repository;

import com.example.Blogging.Entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest   // تتعامل مع الريبوزاتوري  مباشره
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) //link with applicationproprties relace with h2 and تتعامل مع داتا بيز حقيقيه

public class UserRepo {


    @Autowired
    private UserRepository userRepository;


    @Test
    void findByEmailNotFoundTest() {

        Optional<User> existuser = userRepository.findByEmail("nono21@gmail.com");
        assertEquals(false, existuser.isPresent());

    }


    @Test
    void findByEmailFoundTest() {


        Optional<User> existuser = userRepository.findByEmail("shams@gmail.com");
        assertEquals(true, existuser.isPresent());

        assertEquals("shams@gmail.com", existuser.get().getEmail());

    }


}
