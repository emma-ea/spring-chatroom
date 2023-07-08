package com.emma_ea.chat_room.service;

import com.emma_ea.chat_room.model.UserEntity;
import com.emma_ea.chat_room.repository.UserRepository;
import com.emma_ea.chat_room.util.UserNameAlreadyTaken;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Qualifier("UserService")
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public void login(String userName) throws UserNameAlreadyTaken {
        if (repository.findByUserName(userName).isPresent()) {
            throw new UserNameAlreadyTaken(userName);
        }
        repository.save(new UserEntity(userName, LocalDateTime.now()));
    }

    @Override
    public boolean userExists(String username) {
        return repository.findByUserName(username).isPresent();
    }

    @Override
    public void removeUser(String username) {
        Optional<UserEntity> user = repository.findByUserName(username);
        user.ifPresent(repository::delete);
    }

    @Override
    public LocalDateTime getLoginTime(String username) {
        Optional<UserEntity> user = repository.findByUserName(username);
        return user.map(UserEntity::getLoginTime).orElse(null);
    }

    @Override
    public long getUsers() {
        return repository.count();
    }
}
