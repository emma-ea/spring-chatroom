package com.emma_ea.chat_room.exceptions;

import com.emma_ea.chat_room.exceptions.UserNameAlreadyTaken;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ControllerExceptionsAdviser  {

    @ExceptionHandler(UserNameAlreadyTaken.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ModelAndView userNameTakeError(UserNameAlreadyTaken e) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", e.getMessage());
        modelAndView.setViewName("error");
        return modelAndView;
    }


}
