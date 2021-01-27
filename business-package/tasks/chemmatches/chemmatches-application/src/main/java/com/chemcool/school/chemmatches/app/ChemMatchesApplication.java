package com.chemcool.school.chemmatches.app;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(
        scanBasePackages = {"com.chemcool.school.chemmatches"}
)
@EntityScan("com.chemcool.school.chemmatches")
@EnableJpaRepositories("com.chemcool.school.chemmatches")
@EnableEurekaClient
public class ChemMatchesApplication {
    public static void main(String[] args) {
        SpringApplication.run(ChemMatchesApplication.class, args);
    }
}
