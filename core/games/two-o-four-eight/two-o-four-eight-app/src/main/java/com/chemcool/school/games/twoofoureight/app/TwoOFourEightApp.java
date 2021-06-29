package com.chemcool.school.games.twoofoureight.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(
        scanBasePackages = {"com.chemcool.school.games.twoofoureight"})
@EnableEurekaClient
@EntityScan("com.chemcool.school.games.twoofoureight")
@EnableJpaRepositories("com.chemcool.school.games.twoofoureight")
@EnableSwagger2
public class TwoOFourEightApp {
    public static void main(String[] args) { SpringApplication.run(TwoOFourEightApp.class, args); }
}
