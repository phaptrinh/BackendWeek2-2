package com.example.week22;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Week22Application {

    public static void main(String[] args) {
        SpringApplication.run(Week22Application.class, args);
    }

    @Bean
    ModelMapper getModelMapper() {
        return new ModelMapper();
    }

}
