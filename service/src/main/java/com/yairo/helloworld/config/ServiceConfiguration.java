package com.yairo.helloworld.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

@Data
@Configuration
@ConfigurationProperties("hello-world")
@Validated
public class ServiceConfiguration {

    @NotBlank
    private String serviceOwner;

}
