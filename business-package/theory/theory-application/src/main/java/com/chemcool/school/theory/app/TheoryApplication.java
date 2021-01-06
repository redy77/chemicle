package com.chemcool.school.theory.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(
        scanBasePackages = {"com.chemcool.school.theory.app"}
)
@EnableEurekaClient
public class TheoryApplication {
    public static void main(String[] args) {
        SpringApplication.run(TheoryApplication.class, args);
    }
}
