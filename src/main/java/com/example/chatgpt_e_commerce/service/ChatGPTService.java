package com.example.chatgpt_e_commerce.service;

import com.example.chatgpt_e_commerce.dto.ChatGPTRequest;
import com.example.chatgpt_e_commerce.dto.ChatGPTResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ChatGPTService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${openai.api.url}")
    private  String apiUrl;

    public  String chatgptService(String prompt) {
        ChatGPTRequest request = new ChatGPTRequest("gpt-3.5-turbo",prompt);
        ChatGPTResponse chatGPTResponse = restTemplate.postForObject(apiUrl,request, ChatGPTResponse.class);
        return chatGPTResponse.getChoices().get(0).getMessage().getContent();
    }
}
