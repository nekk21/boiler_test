package com.cs.btcoauth2poc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class BtcOauth2pocApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(BtcOauth2pocApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(BtcOauth2pocApplication.class, args);
        LOGGER.info("Btc-Oauth2-poc is up!");
    }

    @GetMapping("/api/token")
    public String getAccessToken(@RegisteredOAuth2AuthorizedClient("btc") OAuth2AuthorizedClient authorizedClient) {
        return authorizedClient.getAccessToken().getTokenValue();
    }

}
