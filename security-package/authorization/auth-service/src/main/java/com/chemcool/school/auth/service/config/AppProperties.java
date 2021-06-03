package com.chemcool.school.auth.service.config;

import lombok.AllArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

import java.util.List;

@ConfigurationProperties(prefix = "app")
@ConstructorBinding
@AllArgsConstructor
public class AppProperties {
    public final Auth auth;
    public final Oauth2 oauth2;

    @AllArgsConstructor
    public static class Auth {
        public final String tokenSecret;
        public final String tokenIssuer;
        public final long tokenExpiration;
    }

    @AllArgsConstructor
    public static class Oauth2 {
        public final List<String> authorizedRedirectUris;
    }
}