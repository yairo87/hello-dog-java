package com.yairo.helloworld.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties("hello-world")
public class ServiceConfiguration {

    private String serviceOwner;

}
