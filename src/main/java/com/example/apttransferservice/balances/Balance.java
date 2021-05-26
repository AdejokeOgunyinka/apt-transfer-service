package com.example.apttransferservice.balances;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class Balance {
    private String account_nr;
    private Double balance;

    public Balance(String account_nr, Double balance) {
        this.account_nr = account_nr;
        this.balance = balance;
    }

    public String getAccount_nr() {
        return account_nr;
    }

    public void setAccount_nr(String account_nr) {
        this.account_nr = account_nr;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Balance{" +
                "account_nr=" + account_nr +
                ", balance=" + balance +
                '}';
    }
}
