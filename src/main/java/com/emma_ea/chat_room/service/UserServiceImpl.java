package com.emma_ea.chat_room.service;

import com.emma_ea.chat_room.configs.RepositoryGuard;
import com.emma_ea.chat_room.model.User;
import com.emma_ea.chat_room.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void login(String username) {
        repository.save(new User(1, username, LocalDateTime.now()));
    }

    @Override
    public boolean userExists(String username) {
        return repository.findbyName(username).isPresent();
    }

    @Override
    public void removeUser(String username) {
        Optional<User> user = repository.findbyName(username);
        user.ifPresent(repository::delete);
    }

    @Override
    public LocalDateTime getLoginTime(String username) {
        Optional<User> user = repository.findbyName(username);
        return user.map(User::loginTime).orElse(null);
    }

    @Override
    public long getUsers() {
        return repository.count();
    }
}
