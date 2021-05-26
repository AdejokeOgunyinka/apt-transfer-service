package com.example.apttransferservice.balances;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BalanceService {
    private final BalanceRepository balanceRepository;

    @Autowired
    public BalanceService (BalanceRepository balanceRepository) {
        this.balanceRepository = balanceRepository;
    }

    public List<Balance> getBalances() {
        return balanceRepository.findAll();
    }

    public Double getBalance(String account_nr) {
        return balanceRepository.findBalanceByAcctNr(account_nr).getBalance();
    }

    public void setNewBalanceAfterCr(String account_nr, Double amount) {
        Double old_balance = balanceRepository.findBalanceByAcctNr(account_nr).getBalance();
        Double new_balance = old_balance + amount;
        balanceRepository.findBalanceByAcctNr(account_nr).setBalance(new_balance);
    }

    public String setNewBalanceAfterDr(String account_nr, Double amount) {
        Double old_balance = balanceRepository.findBalanceByAcctNr(account_nr).getBalance();
        if (amount <= old_balance) {
            Double new_balance = old_balance - amount;
            balanceRepository.findBalanceByAcctNr(account_nr).setBalance(new_balance);
        }
        return "Insufficient Balance";
    }
}
