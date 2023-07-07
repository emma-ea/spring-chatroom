package com.emma_ea.chat_room.model;

import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

public record User (
    @Id Integer id,
    String name,
    LocalDateTime loginTime
) {}
