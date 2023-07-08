package com.emma_ea.chat_room.controller;

import com.emma_ea.chat_room.service.UserService;
import com.emma_ea.chat_room.exceptions.UserNameAlreadyTaken;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
@RequestMapping("/")
public class UserController implements WebMvcConfigurer {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/chat").setViewName("chat");
    }

    @GetMapping
    public String home() {
        return "index";
    }

    @PostMapping("login")
    public String loginUser(@RequestBody String userName) throws UserNameAlreadyTaken {
        service.login(userName);
        return "redirect:/chat";
    }

}
