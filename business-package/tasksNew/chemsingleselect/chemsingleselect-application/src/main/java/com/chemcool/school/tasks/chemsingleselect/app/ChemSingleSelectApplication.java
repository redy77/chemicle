package com.chemcool.school.tasks.chemsingleselect.app;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(
        scanBasePackages = {"com.chemcool.school.tasks.chemsingleselect"}
)
@EntityScan("com.chemcool.school.tasks.chemsingleselect")
@EnableJpaRepositories("com.chemcool.school.tasks.chemsingleselect")
@EnableEurekaClient
class ChemSingleSelectApplication {
    public static void main(String[] args) {
        SpringApplication.run(ChemSingleSelectApplication.class, args);
    }
}
