package com.example.demo;

import com.example.demo.entity.User;
import com.example.demo.response.ResponseData;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@Sql("/clear_test_database.sql")
@Sql("/create_test_database.sql")
public class UserControllerTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    public void getAllUserTest(){
        ResponseEntity<ResponseData> response = testRestTemplate.getForEntity("/api/user/", ResponseData.class);
        ResponseData responseData = response.getBody();
        List<User> userListResponse = (List<User>) responseData.getData();
        ObjectMapper mapper = new ObjectMapper();
        // User user = mapper.convertValue(userListResponse.get(0), User.class);
        List<User> userList = mapper.convertValue(userListResponse, new TypeReference<List<User>>() { });
        assertEquals(userList.get(0).getId(), 11);
        assertEquals(userList.get(0).getName(), "name1");
        assertEquals(userList.get(1).getId(), 12);
        assertEquals(userList.get(1).getName(), "name2");
    }
}
