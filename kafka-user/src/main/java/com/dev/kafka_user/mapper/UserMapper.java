package com.dev.kafka_user.mapper;


import com.dev.kafka_user.dto.UserDto;
import com.dev.kafka_user.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User toEntity(UserDto dto) {
       /* User user = new User();
        user.setFirstname(dto.getFirstname());
        user.setLastname(dto.getLastname());
        user.setAge(dto.getAge());
        return user;*/
        return null;
    }

    public UserDto toDto(User user) {
    /*    UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstname(user.getFirstname());
        userDto.setLastname(user.getLastname());
        userDto.setAge(user.getAge());
        return userDto;*/
        return null;
    }

    public void toUpdate(User user, UserDto dto) {
/*        if (dto == null) return;
        if (dto.getFirstname() != null) user.setFirstname(dto.getFirstname());
        if (dto.getLastname() != null) user.setLastname(dto.getLastname());
        if (dto.getAge() != null) user.setAge(dto.getAge());*/


    }
}
