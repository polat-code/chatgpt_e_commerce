package com.example.chatgpt_e_commerce.config;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JSONParserConfig {
    @Bean
    public JsonFactory jsonFactory() {
        return new JsonFactory();
    }
}
