package com.chemcool.school.apigateway.configuration.swagger;


import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@EnableSwagger2
@Component
@Primary
public class SwaggerResourcesEurekaProvider implements SwaggerResourcesProvider{

    private final DiscoveryClient discoveryClient;
    private List<SwaggerResource> swaggerResources;

    public SwaggerResourcesEurekaProvider(DiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;
    }

    @Override
    public List<SwaggerResource> get() {
        return swaggerResources;
    }

    @PostConstruct
    private void refreshListOfResources() {
        List<SwaggerResource> swaggerResources = new ArrayList<>();
        for (String service : discoveryClient.getServices()) {
            if (service.equals("config-service") || service.equals("web-api-gateway")) {
                continue;
            }
            swaggerResources.add(createResource(service, service,"2.0"));
        }
        this.swaggerResources = swaggerResources;
    }

    private SwaggerResource createResource(String name, String location, String version) {
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(fancyNameConverter(name));
        swaggerResource.setLocation("/" + location + "/v2/api-docs");
        swaggerResource.setSwaggerVersion(version);
        log.info(fancyNameConverter(name) + " registered");
        return swaggerResource;
    }

    private String fancyNameConverter(String str) {
        return str.toUpperCase().charAt(0) + str.substring(1, str.length() - 12);
    }
}

