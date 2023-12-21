package com.example.chatgpt_e_commerce.controller;

import com.example.chatgpt_e_commerce.dto.ChatGPTRequest;
import com.example.chatgpt_e_commerce.dto.ChatGPTResponse;
import com.example.chatgpt_e_commerce.service.DecisionService;
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

    @Value("${openai.model}")
    private String model;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${openai.api.url}")
    private String apiUrl;

    @Autowired
    private DecisionService decisionService;

    @GetMapping("/chat")
    public String chat(@RequestParam("prompt") String prompt) {
        ChatGPTRequest request = new ChatGPTRequest("gpt-3.5-turbo",prompt);
        ChatGPTResponse chatGPTResponse = restTemplate.postForObject(apiUrl,request, ChatGPTResponse.class);
        return chatGPTResponse.getChoices().get(0).getMessage().getContent();
    }

    @GetMapping("/chat-request")
    public String chatRequest(@RequestParam("prompt") String prompt) {
        return decisionService.makeDecisionAndExecute(prompt);
    }
}
