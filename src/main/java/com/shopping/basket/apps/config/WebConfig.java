package com.shopping.basket.apps.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // Apply CORS globally for all endpoints
            .allowedOrigins("*")     // Allow requests from any origin
            .allowedMethods("GET", "POST", "PUT", "DELETE")  // Allowed HTTP methods
            .allowedHeaders("*");    // Allowed headers
    }
}