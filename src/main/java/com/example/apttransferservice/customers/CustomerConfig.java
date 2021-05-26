package com.example.apttransferservice.customers;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CustomerConfig {
    @Bean
    CommandLineRunner commandLineRunner (CustomerRepository repository) {
        return args -> {
            Customer one = new Customer(
                    "Adejoke Ogunyinka",
                    "3104841829",
                    "FirstBank"
            );

            Customer two = new Customer(
                    "Goodness Williams",
                    "3112337668",
                    "FirstBank"
            );

            repository.saveAll(
                    List.of(one, two)
            );
        };
    }
}
