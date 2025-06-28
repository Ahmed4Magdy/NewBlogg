package com.example.Blogging.Mapper;


import com.example.Blogging.Dto.UserDto;
import com.example.Blogging.Entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring",uses = {PostMapper.class})
public interface UserMapper {

    // convert entity to dto
    UserDto  maptodto (User entity);

    //convert dto to entity
    User maptoentity (UserDto dto);

}

