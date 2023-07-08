package com.emma_ea.chat_room.service;

import com.emma_ea.chat_room.repository.UserRepository;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserEntityServiceImplTest {

    @Resource
    UserRepository repository;
    @Resource
    UserService userService;

    @BeforeEach
    void setUp() {
        repository.deleteAll();
    }

    @Test
    void login() {
        userService.login("John");
        assertEquals(1, repository.count());
    }

    @Test
    void userExists() {
        userService.login("John");
        boolean res = userService.userExists("John");
        assertTrue(res);
    }

    @Test
    void removeUser() {
        userService.removeUser("John");
        boolean res = userService.userExists("John");
        assertFalse(res);
    }

    @Test
    void getLoginTime() {
        userService.login("John");
        LocalDateTime time = userService.getLoginTime("John");
        assertEquals(LocalDateTime.now().getDayOfWeek(), time.getDayOfWeek());
        assertEquals(LocalDateTime.now().toLocalTime().getMinute(), time.toLocalTime().getMinute());
    }

    @Test
    void getUsers() {
        long users = userService.getUsers();
        assertEquals(0, users);
    }
}