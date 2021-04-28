package com.chemcool.school.tasks.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.chemcool.school.tasks.chemequations"})
@EntityScan("com.chemcool.school.tasks.chemequations")
@EnableJpaRepositories("com.chemcool.school.tasks.chemequations")
@EnableEurekaClient
public class TasksApplication {
    public static void main(String[] args) {
        SpringApplication.run(TasksApplication.class,args);
    }
}

