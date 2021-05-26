package com.example.apttransferservice.balances;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BalanceRepository extends JpaRepository<Balance, Long> {
    Balance findBalanceByAcctNr(String account_nr);
}
