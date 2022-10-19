package com.example.demo.service;

import com.example.demo.dao.UserDao;
import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserDao userDao;

    @Override
    @Transactional(readOnly = true)
    public List<UserDto> getAllUser() {
        return UserMapper.getUserDtoList(userDao.findAll());
    }

    @Override
    public void addUser(User user) {
        userDao.save(user);
    }

    @Override
    public List<UserDto> findByName(String name) {
        return UserMapper.getUserDtoList(userDao.findByName(name));
    }

    @Override
    public List<UserDto> findByNameContain(String name) {
        return UserMapper.getUserDtoList(userDao.findByNameContain(name));
    }
}
