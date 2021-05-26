package com.example.apttransferservice.balances;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BalanceService {
    private final BalanceRepository balanceRepository;

    @Autowired
    public BalanceService (BalanceRepository balanceRepository) {
        this.balanceRepository = balanceRepository;
    }

    public Double getBalance(String account_nr) {
        return balanceRepository.findBalanceByAcctNr(account_nr).getBalance();
    }
}
