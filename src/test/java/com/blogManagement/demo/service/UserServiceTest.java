package com.blogManagement.demo.service;

import com.blogManagement.demo.entity.User;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void testLoginSuccessful() {
        User testUser = userService.login("manager@email.com", "manager");
        assertEquals("Roberta", testUser.getFirstName());
        assertEquals("Allen", testUser.getLastName());
    }

    @Test
    public void testLoginFailedIncorrectUsername() {
        User testUser = userService.login("notmanager@email.com", "manager");
        assertNull(testUser);
    }

    @Test
    public void testLoginFailedIncorrectPassword() {
        User testUser = userService.login("manager@email.com", "admin");
        assertNull(testUser);
    }
}
