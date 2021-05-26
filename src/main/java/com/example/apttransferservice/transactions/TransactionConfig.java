package com.example.apttransferservice.transactions;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class TransactionConfig {
    @Bean
    CommandLineRunner commandLineRunner (TransactionRepository repository) {
        return args -> {
            Transaction one = new Transaction(
                    150000.00,
                    "3104841829",
                    "Cr"
            );

            Transaction two = new Transaction(
                    20000.00,
                    "3112337668",
                    "Dr"
            );

            repository.saveAll(
                    List.of(one, two)
            );
        };
    }
}
