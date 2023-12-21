package com.example.chatgpt_e_commerce.service;

import com.example.chatgpt_e_commerce.entity.Category;
import com.example.chatgpt_e_commerce.entity.Intent;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DecisionService {

    private IntentService intentService;


    private CategoryService categoryService;

    private SubCategoryService subCategoryService;


    public String makeDecisionAndExecute(String userSentence){
        String userIntent = intentService.solveIntent(userSentence);
        String categoryJson = categoryService.solveCategory(userSentence);

        Intent intentObj = new Intent();
        Category categoryObj = new Category();


        System.out.println(userIntent);
        System.out.println(categoryJson);

        ObjectMapper mapper = new ObjectMapper();
        try {
            intentObj = mapper.readValue(userIntent, Intent.class);
            //System.out.println("Intent: " + intentObj.getIntent());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            categoryObj = mapper.readValue(categoryJson, Category.class);
            //System.out.println("Intent: " + categoryObj.getCategory());
        } catch (Exception e) {
            e.printStackTrace();
        }


        String subcategoryJson = subCategoryService.solveSubcategory(categoryObj,userSentence);
        System.out.println(subcategoryJson);


        /*
        if(userIntent.equals("Search") ) {

        }else if (userIntent.equals("Not-Found")) {
            return "Not-Found";
        }
         */
        return "nothing";
    }
}
