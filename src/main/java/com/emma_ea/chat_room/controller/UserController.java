package com.emma_ea.chat_room.controller;

import com.emma_ea.chat_room.service.UserService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    public void loginUser() {}

}
