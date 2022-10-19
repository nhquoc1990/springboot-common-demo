package com.example.demo.mapper;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {

    public static UserDto getUserDto(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setBirthDay(user.getBirthDay());
        userDto.setAddress(user.getAddress());
        return userDto;
    }

    public static List<UserDto> getUserDtoList(List<User> userList){
        List<UserDto> userListDto = new ArrayList<>();
        for (User user : userList) {
            userListDto.add(getUserDto(user));
        }
        return userListDto;
    }

}
