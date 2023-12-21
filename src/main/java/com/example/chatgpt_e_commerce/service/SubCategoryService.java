package com.example.chatgpt_e_commerce.service;


import com.example.chatgpt_e_commerce.entity.Category;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SubCategoryService {

    private ChatGPTService chatGPTService;

    public String solveSubcategory(Category categoryObj, String userSentence) {
        String subcategory="";

        if(categoryObj.getCategory().equals("Electronics")) {
            String promptTemplate = "I have a sentence that may include a product, and I need your assistance in classifying this product into the correct subcategory under Electronics. The main category of Electronics is divided into the following subcategories:\n\n" +
                    "1. **Consumer Electronics**: Includes Smartphones, Tablets, Cameras, Personal Computers.\n" +
                    "2. **Home Appliances**: Includes Refrigerators, Microwaves, Washing Machines, Vacuum Cleaners.\n" +
                    "3. **Audio and Video**: Includes Televisions, Speakers, Headphones, Media Players.\n" +
                    "4. **Computers and Accessories**: Includes Laptops, Desktops, Peripherals, Storage Devices.\n\n" +
                    "Your task is to identify the product in the sentence and classify it into one of these subcategories. If the product does not fit into any of these subcategories, then classify it as \"None\".\n\n" +
                    "Here are some examples for clarification:\n\n" +
                    "- \"I'm thinking of buying the latest model of the XYZ smartphone\" should be classified under **Consumer Electronics** and you must return {\"subcategory\":\"Consumer Electronics\"}.\n" +
                    "- \"My kitchen needs a new powerful microwave\" should be classified under **Home Appliances** and you must return {\"subcategory\":\"Home Appliances\"}.\n" +
                    "- \"I'm looking for a new set of wireless headphones for jogging\" should be classified under **Audio and Video** and you must return {\"subcategory\":\"Audio and Video\"}.\n" +
                    "- \"I need a new external hard drive for my laptop\" should be classified under **Computers and Accessories** and you must return {\"subcategory\":\"Computers and Accessories\"}.\n\n" +
                    "Based on these guidelines, please classify the product in the following sentence: \"%s\"";

            String prompt = String.format(promptTemplate, userSentence);
            subcategory = chatGPTService.chatgptService(prompt);
        }

        return subcategory;
    }
}
