package com.emma_ea.chat_room.repository;

import com.emma_ea.chat_room.model.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Integer> {
    Optional<UserEntity> findByUserName(String username);
}
