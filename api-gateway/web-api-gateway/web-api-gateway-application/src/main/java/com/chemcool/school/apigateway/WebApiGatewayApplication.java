package com.chemcool.school.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.retry.annotation.EnableRetry;

@SpringBootApplication(scanBasePackages = {"com.chemcool.school.apigateway"})
@EnableEurekaClient
@EnableZuulProxy
@ConfigurationPropertiesScan("com.chemcool.school.apigateway")
@EnableRetry
public class WebApiGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebApiGatewayApplication.class, args);
    }
}
