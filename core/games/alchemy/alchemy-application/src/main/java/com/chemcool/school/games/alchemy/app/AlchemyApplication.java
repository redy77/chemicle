package com.chemcool.school.games.alchemy.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(
		scanBasePackages = {"com.chemcool.school.games.alchemy"}
)
@EnableSwagger2
@EnableEurekaClient
public class AlchemyApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlchemyApplication.class, args);
	}

}
