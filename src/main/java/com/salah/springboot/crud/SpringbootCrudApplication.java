package com.salah.springboot.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@ConfigurationPropertiesScan("com.salah.springboot.crud.PropConfig")
@EnableAspectJAutoProxy
public class SpringbootCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootCrudApplication.class, args);
    }

}

