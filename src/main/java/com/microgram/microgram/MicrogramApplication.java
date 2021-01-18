package com.microgram.microgram;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class MicrogramApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicrogramApplication.class, args);
    }

}
