package com.emma_ea.chat_room.controller;

import com.emma_ea.chat_room.service.UserService;
import com.emma_ea.chat_room.exceptions.UserNameAlreadyTaken;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String loginUser(@RequestBody String userName, HttpServletRequest request) throws UserNameAlreadyTaken {
        String name = userName.split("=")[1];
        service.login(name);
        request.getSession().getServletContext().setAttribute("username", name);
        return "redirect:/chat";
    }

    @GetMapping("logout")
    public String logout() {
        return "/";
    }

}
