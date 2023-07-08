package com.emma_ea.chat_room.service;

import com.emma_ea.chat_room.exceptions.UserNameAlreadyTaken;

import java.time.LocalDateTime;

public interface UserService {

    void login(String username) throws UserNameAlreadyTaken;

    boolean userExists(String username);

    void removeUser(String username);

    LocalDateTime getLoginTime(String username);

    long getUsers();

}
