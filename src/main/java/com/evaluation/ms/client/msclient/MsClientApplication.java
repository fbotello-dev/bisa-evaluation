package com.evaluation.ms.client.msclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"com.evaluation.ms.client.msclient.infrastructure.persistence.entity"})
@EnableJpaRepositories(basePackages = {"com.evaluation.ms.client.msclient.infrastructure.persistence.repository"})
@ComponentScan(basePackages = "com.evaluation.ms.client.msclient")
public class MsClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsClientApplication.class, args);
    }

}
