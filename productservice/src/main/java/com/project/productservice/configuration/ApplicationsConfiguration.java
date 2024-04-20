package com.project.productservice.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
@Configuration

public class ApplicationsConfiguration {
    @Bean
    public RestTemplate restTemplate()
    {
        return  new RestTemplate();
    }
}
