package com.example.demo.service;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    public List<UserDto> getAllUser();

    public void addUser(User user);

    List<UserDto> findByName(String name);

    List<UserDto> findByNameContain(String name);
}
