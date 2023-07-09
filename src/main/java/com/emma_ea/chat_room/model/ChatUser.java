package com.emma_ea.chat_room.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ChatUser {

        @NotBlank(message = "User name cannot be empty")
        @Size(min = 4, max = 11, message = "User name cannot be less than 4 or exceed 11")
        private String userName;

        public String getUserName() {
                return userName;
        }

        public void setUserName(String userName) {
                this.userName = userName;
        }
}
