package com.example.Blogging.Mapper;

import com.example.Blogging.Dto.PostDto;
import com.example.Blogging.Entity.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",uses = {UserMapper.class})
public interface PostMapper {

    //convert from entity to dto

    PostDto maptodto(Post entity);

    //convert from dto to entity
    Post maptoentity (PostDto dto);

}
