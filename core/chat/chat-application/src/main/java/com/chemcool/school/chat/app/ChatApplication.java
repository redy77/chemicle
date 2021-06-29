package com.chemcool.school.chat.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(
        scanBasePackages = {"com.chemcool.school.chat"}
)
@EntityScan("com.chemcool.school.chat")
@EnableEurekaClient
@EnableJpaRepositories("com.chemcool.school.chat")
@EnableSwagger2
public class ChatApplication { 
    public static void main(String[] args) {
        SpringApplication.run(ChatApplication.class, args);
    }
}
