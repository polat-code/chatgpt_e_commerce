package com.example.chatgpt_e_commerce.dto;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ChatGPTRequest {

    private String model;
    private List<Message> messages;
    private Double temperature;
    public ChatGPTRequest(String model, String prompt) {
        this.model = model;
        this.messages = new ArrayList<>();
        this.messages.add(new Message("user",prompt));
        this.temperature = 0.0;
    }
}
