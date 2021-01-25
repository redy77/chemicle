package com.chemcool.school.tasks.chemfixedanswer.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(
        scanBasePackages = {"com.chemcool.school.tasks.chemfixedanswer"}
)
@EntityScan("com.chemcool.school.tasks.chemfixedanswer")
@EnableJpaRepositories("com.chemcool.school.tasks.chemfixedanswer")
@EnableEurekaClient
public class ChemFixedAnswerTasksApplication {
    public static void main(String[] args) {
        SpringApplication.run(ChemFixedAnswerTasksApplication.class, args);
    }
}
