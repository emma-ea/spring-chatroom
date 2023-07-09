package com.emma_ea.chat_room.exceptions;

public class UserNameAlreadyTaken extends AppExceptions {

    public UserNameAlreadyTaken(String msg) {
        super(String.format("User name >> %s << is already taken \n", msg));
    }
}
