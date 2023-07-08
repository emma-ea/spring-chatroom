package com.emma_ea.chat_room.controller;

import com.emma_ea.chat_room.service.UserService;
import com.emma_ea.chat_room.util.UserNameAlreadyTaken;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
public class UserController implements WebMvcConfigurer {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/chat").setViewName("chat");
    }

    @PostMapping("/login")
    @ResponseStatus(HttpStatus.CREATED)
    public String loginUser(@RequestBody String userName) throws UserNameAlreadyTaken {
        service.login(userName);
        return "redirect:/chat";
    }

}
