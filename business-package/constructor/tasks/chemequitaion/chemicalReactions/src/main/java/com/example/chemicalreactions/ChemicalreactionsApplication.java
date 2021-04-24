package com.example.chemicalreactions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ChemicalreactionsApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(ChemicalreactionsApplication.class, args);
    }

    //для того чтобы spring boot видел файлы js
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }

}
