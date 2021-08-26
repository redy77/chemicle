package com.chemcool.school.constructor.app;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(
        scanBasePackages = {"com.chemcool.school.constructor"}
)
//todo при создании базы раскомментировать
//@EntityScan("com.chemcool.school.constructor")
//@EnableJpaRepositories("com.chemcool.school.constructor")
@EnableEurekaClient
@EnableSwagger2
public class ConstructorApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConstructorApplication.class, args);
    }
}
