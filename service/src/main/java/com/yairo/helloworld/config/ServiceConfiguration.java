package com.yairo.helloworld.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

@Data
@Configuration
@ConfigurationProperties("hello-world")
@Validated
public class ServiceConfiguration {

    private String serviceOwner;

}
