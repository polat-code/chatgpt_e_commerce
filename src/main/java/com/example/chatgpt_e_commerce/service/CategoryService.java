package com.example.chatgpt_e_commerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private ChatGPTService chatGPTService;
    public String solveCategory(String userSentence) {
        String promptTemplate = "I am working on a categorization task and need your help to classify products into specific categories. Here are the categories:\n" +
                "1. Fashion and Apparel\n" +
                "2. Electronics\n" +
                "3. Home and Garden\n" +
                "4. Health and Beauty\n" +
                "5. Toys and Games\n" +
                "6. Books and Media\n" +
                "7. Sports and Outdoors\n\n" +
                "If a product doesn't fit into any of these categories, please respond with \"not-found.\" Here are some examples to illustrate:\n" +
                "- \"I want to buy a red t-shirt\" should be categorized as Fashion and Apparel, and you must return {\"category\":\"Fashion and Apparel\"}.\n" +
                "- \"Looking for the latest smartphone\" should be categorized as Electronics, and you must return {\"category\":\"Electronics\"}.\n" +
                "- \"I need a new lawn mower\" should be categorized as Home and Garden, and you must return {\"category\":\"Home and Garden\"}.\n" +
                "- \"Searching for organic skin care products\" should be categorized as Health and Beauty, and you must return {\"category\":\"Health and Beauty\"}.\n" +
                "- \"Interested in a board game for kids\" should be categorized as Toys and Games, and you must return {\"category\":\"Toys and Games\"}.\n" +
                "- \"I'm trying to find a new science fiction novel\" should be categorized as Books and Media, and you must return {\"category\":\"Books and Media\"}.\n" +
                "- \"I'm shopping for a new camping tent\" should be categorized as Sports and Outdoors, and you must return {\"category\":\"Sports and Outdoors\"}.\n\n" +
                "Please categorize the following sentence: \"%s\"";
        ; // This is your sentence to be categorized
        String prompt = String.format(promptTemplate, userSentence);

        return chatGPTService.chatgptService(prompt);
    }
}
