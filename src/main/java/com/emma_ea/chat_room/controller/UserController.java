package com.emma_ea.chat_room.controller;

import com.emma_ea.chat_room.model.ChatUser;
import com.emma_ea.chat_room.service.UserService;
import com.emma_ea.chat_room.exceptions.UserNameAlreadyTaken;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
@RequestMapping("/")
@Validated
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
    public String home(Model model) {
        ChatUser chatUser = new ChatUser();
        model.addAttribute("chatUser", chatUser);
        return "index";
    }

    @PostMapping("login")
    public String loginUser(
            @Valid @ModelAttribute("chatUser") ChatUser chatUser,
            BindingResult result,
            HttpServletRequest request
    ) throws Exception {

        if (result.hasErrors()) {
            System.out.println(result.getFieldError().getField());
            return "/";
        }

        service.login(chatUser.getUserName());
        request.getSession().getServletContext()
                .setAttribute("username", chatUser.getUserName());
        return "redirect:/chat";
    }

    @GetMapping("logout")
    public String logout() {
        return "index";
    }

}
