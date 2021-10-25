package com.chemcool.school.tasks.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = {"com.chemcool.school.tasks"})
@EntityScan("com.chemcool.school.tasks")
@EnableJpaRepositories("com.chemcool.school.tasks")
@EnableEurekaClient
//@EnableSwagger2
public class TasksApplication {
    public static void main(String[] args) {
        SpringApplication.run(TasksApplication.class, args);
    }
}
