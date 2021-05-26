package com.example.apttransferservice.balances;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class BalanceConfig {
    @Bean
    CommandLineRunner commandLineRunner (BalanceRepository repository) {
        return args -> {
            Balance one = new Balance(
                    "3104841829",
                    300000.00
            );

            Balance two = new Balance(
                    "3112337668",
                    258000.00
            );

            repository.saveAll(
                    List.of(one, two)
            );
        };
    }
}
