package com.example.Blogging.Repository;

import com.example.Blogging.Entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);


    @EntityGraph(attributePaths = {"posts"})
    @Query("SELECT u FROM User u ")
    List<User> findAllUsers();


}
