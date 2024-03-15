package com.example.chatgptbot.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChatGptRequest {

    String model;
    List<Message> messages;

    public ChatGptRequest(String model, String content) {
        this.model = model;
        this.messages = new ArrayList<>();
        this.messages.add(new Message("user",content));
    }
}
