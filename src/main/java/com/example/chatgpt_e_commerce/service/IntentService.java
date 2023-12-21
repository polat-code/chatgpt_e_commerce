package com.example.chatgpt_e_commerce.service;

import com.example.chatgpt_e_commerce.dto.ChatGPTRequest;
import com.example.chatgpt_e_commerce.dto.ChatGPTResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class IntentService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private ChatGPTService chatGPTService;

    @Value("${openai.api.url}")
    private String apiUrl;

    public String solveIntent(String userSentence) {
        String promptTemplate = "I am working on an intent classification task and need your help to identify the intent of given sentences and give me the intent. The possible intents are:\n\n" +
                "1. **Search**: This intent includes sentences where the user is looking for information, searching for a specific item or service, or expressing a desire to purchase something.\n" +
                "2. **Log In**: This intent is for sentences where the user expresses a need to access their account or a secure area.\n" +
                "3. **Not Found**: Use this intent for sentences that do not fit into the Search or Log In categories.\n\n" +
                "Here are some examples to illustrate each intent:\n\n" +
                "- \"Can you tell me the best time to visit Paris?\" should be classified as **Search** and you must return only {\"intent\":\"Search\"} in JSON format.\n" +
                "- \"I'm trying to find a good Italian restaurant nearby\" should be classified as **Search** and you must return only {\"intent\":\"Search\"} in JSON format.\n" +
                "- \"I'm looking to buy a new laptop, any suggestions?\" should be classified as **Search** and you must return only {\"intent\":\"Search\"} in JSON format.\n" +
                "- \"How do I sign into my online banking account?\" should be classified as **Log In** and you must return only {\"intent\":\"Log in\"} in JSON format.\n" +
                "- \"I need help resetting my email password\" should be classified as **Log In** and you must return only {\"intent\":\"Log in\"} in JSON format.\n" +
                "- \"What's the weather like today?\" should be classified as **Not Found** and you must return only {\"intent\":\"Not Found\"} in JSON format.\n" +
                "- \"Tell me a joke\" should be classified as **Not Found** and you must return only {\"intent\":\"Not Found\"} in JSON format.\n\n" +
                "Based on these guidelines, please classify the following sentence: \"%s\"";

        // Replace with the sentence you want to classify
        String prompt = String.format(promptTemplate, userSentence);
        return chatGPTService.chatgptService(prompt);
    }
}
