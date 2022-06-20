package com.springbootsales;

import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean(name = "applicationName")
    public String applicationName(){
        return "Sales System";
    }
}
