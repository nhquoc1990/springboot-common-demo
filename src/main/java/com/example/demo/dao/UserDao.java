package com.example.demo.dao;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
    List<User> findByName(String name);

    @Query("Select user from User user where  user.name LIKE  %?1%")
    List<User> findByNameContain(String name);
}
