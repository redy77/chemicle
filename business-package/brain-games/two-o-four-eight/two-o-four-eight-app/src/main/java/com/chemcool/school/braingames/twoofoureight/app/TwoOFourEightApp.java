package com.chemcool.school.braingames.twoofoureight.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(
        scanBasePackages = {"com.chemcool.school.braingames.twoofoureight"})
@EnableEurekaClient
public class TwoOFourEightApp {
    public static void main(String[] args) { SpringApplication.run(TwoOFourEightApp.class, args); }
}
