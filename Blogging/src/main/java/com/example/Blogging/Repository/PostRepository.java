package com.example.Blogging.Repository;

import com.example.Blogging.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {


    void deleteByIdBetween(Long startId, Long endId);

}
