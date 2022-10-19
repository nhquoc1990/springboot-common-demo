package com.example.demo;

import com.example.demo.entity.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class MainTest {
    public static void main(String[] args){
        List<User> userList = Arrays.asList(
                User.builder().id(1L).name("name1").birthDay(new Date()).password("password1").address("address3").build(),
                User.builder().id(2L).name("name3").birthDay(new Date()).password("password6").address("address2").build(),
                User.builder().id(3L).name("name2").birthDay(new Date()).password("password3").address("address1").build()
        );

        userList.sort((u1, u2) -> {
            if (u1.getName().compareTo(u2.getName()) == 0) {
                return 0;
            }
            return u1.getName().compareTo(u2.getName()) > 0 ? 1 : -1;
            }
        );
        Collections.reverse(userList);
        for(User user : userList){
            System.out.print("id: " + user.getId() + " ");
            System.out.print("name: " + user.getName() + " ");
            System.out.print("address: " + user.getAddress() + " ");
            System.out.print("password: " + user.getPassword() + "\n");
        }



    }
}
