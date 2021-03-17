package com.chemcool.school.answerstask.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(
        scanBasePackages = {"com.chemcool.school.answerstask"}
)
@EntityScan("com.chemcool.school.answerstask")
@EnableJpaRepositories("com.chemcool.school.answerstask")
@EnableEurekaClient
public class AnswersTaskApplication {
    public static void main(String[] args) {
        SpringApplication.run(AnswersTaskApplication.class, args);
    }
}
