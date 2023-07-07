package com.emma_ea.chat_room.service;

import java.time.LocalDateTime;

public interface UserService {

    void login(String username);

    boolean userExists(String username);

    void removeUser(String username);

    LocalDateTime getLoginTime(String username);

    long getUsers();

}
