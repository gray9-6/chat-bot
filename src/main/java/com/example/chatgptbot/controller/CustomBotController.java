package com.example.chatgptbot.controller;

import com.example.chatgptbot.dto.ChatGptRequest;
import com.example.chatgptbot.dto.ChatGptResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/bot")
public class CustomBotController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${openai.model}")
    private String model;

    @Value("${openai.api.url}")
    private String apiUrl;


    @GetMapping("/chat")
    public String chatWithGpt(@RequestParam("content") String content){
        ChatGptRequest chatGptRequest = new ChatGptRequest(model,content);
//        return restTemplate.postForObject(apiUrl,chatGptRequest, ChatGptResponse.class);

        ChatGptResponse chatGptResponse =  restTemplate.postForObject(apiUrl,chatGptRequest, ChatGptResponse.class);
        return chatGptResponse.getChoices().get(0).getMessage().getContent();
    }
}
