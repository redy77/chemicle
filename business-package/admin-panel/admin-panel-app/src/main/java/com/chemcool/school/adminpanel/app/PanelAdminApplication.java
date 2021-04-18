package com.chemcool.school.adminpanel.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication(scanBasePackages = "com.chemcool.school.adminpanel")
@EnableEurekaClient
public class PanelAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(PanelAdminApplication.class, args);
    }

}
