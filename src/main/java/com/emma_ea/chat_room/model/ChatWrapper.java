package com.emma_ea.chat_room.model;

import jakarta.validation.constraints.NotBlank;

public record ChatWrapper(@NotBlank String message) { }
