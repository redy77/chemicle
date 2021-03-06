package com.chemcool.school.theory.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(
        scanBasePackages = {"com.chemcool.school.theory"}
)
@EntityScan("com.chemcool.school.theory")
@EnableJpaRepositories("com.chemcool.school.theory")
@EnableEurekaClient
@EnableSwagger2
public class TheoryApplication {
    public static void main(String[] args) {
        SpringApplication.run(TheoryApplication.class, args);
    }
}
