package com.chemcool.school.article.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * class that launches the application
 *
 * @autor Иван Полещук
 */
@SpringBootApplication(scanBasePackages = "com.chemcool.school.article")
@EntityScan("com.chemcool.school.article")
@EnableJpaRepositories("com.chemcool.school.article")
@EnableEurekaClient
public class ArticleApplication {
    public static void main(String[] args) {
        SpringApplication.run(ArticleApplication.class, args);
    }
}
