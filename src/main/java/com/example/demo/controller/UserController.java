package com.example.demo.controller;

import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.response.ResponseData;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/user/")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<ResponseData> getAllUser() {
        List<UserDto> userDtoList = userService.getAllUser();
        if (userDtoList.isEmpty()) {
            return new ResponseEntity(new ResponseData("not found", new ArrayList<>()), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(new ResponseData("ok", userService.getAllUser()), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ResponseData> addUser(@Validated @RequestBody User user) {
        userService.addUser(user);
        return new ResponseEntity(new ResponseData("ok", user), HttpStatus.OK);
    }


    @GetMapping("/find-by-name")
    public ResponseEntity<ResponseData> findByName(@RequestParam String name, @RequestParam(defaultValue = "false") boolean isContain) {
        List<UserDto> userDtoList;
        if (isContain) {
            userDtoList = userService.findByNameContain(name);
        } else {
            userDtoList = userService.findByName(name);
        }
        if (userDtoList.isEmpty()) {
            return new ResponseEntity(new ResponseData("not found", new ArrayList<>()), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(new ResponseData("ok", userDtoList), HttpStatus.OK);
    }

}
