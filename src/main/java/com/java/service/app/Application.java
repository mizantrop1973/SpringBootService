package com.java.service.app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.java.service")
@EnableJpaRepositories(basePackages = "com.java.service.repositories")
@EntityScan(basePackages = "com.java.service.models")
public class Application {


    public static void main(String[] args) {
        SpringApplication.run(Application.class);

    }
}
