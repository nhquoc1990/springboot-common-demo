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
                new User(1L, "name1", new Date(), "address3", "password2"),
                new User(2L, "name3", new Date(), "address2", "password6"),
                new User(3L, "name2", new Date(), "address1", "password3")
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
