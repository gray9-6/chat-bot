package com.example.chatgptbot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {

    private String role;   // which role is accessing the content
    private String content;  // what is the content that you are searching

}
