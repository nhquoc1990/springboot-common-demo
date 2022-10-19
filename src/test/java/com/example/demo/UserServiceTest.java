package com.example.demo;

import com.example.demo.dao.UserDao;
import com.example.demo.dto.UserDto;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


@SpringBootTest
@ActiveProfiles("test")
@Sql("/clear_test_database.sql")
@Sql("/create_test_database.sql")
class UserServiceTest {

    @MockBean
    UserService userService;

    @Autowired
    static UserDao userDao;

    @Test
    void contextLoads() {
    }

    @Test
    void testUserService(){
        when(userService.getAllUser()).thenReturn(
                Stream.of(
                        new UserDto(1L, "Nametest", new Date(), "addresstest"),
                        new UserDto(2L, "Nametest2", new Date(), "addresstest2")
                ).collect(Collectors.toList())
        );
        assertEquals(userService.getAllUser().size(), 2);
    }


}
