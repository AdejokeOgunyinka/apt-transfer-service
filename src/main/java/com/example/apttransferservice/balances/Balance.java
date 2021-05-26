package com.example.apttransferservice.balances;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class Balance {
    private Integer account_nr;
    private Long balance;

    public Balance(Integer account_nr, Long balance) {
        this.account_nr = account_nr;
        this.balance = balance;
    }

    public Integer getAccount_nr() {
        return account_nr;
    }

    public void setAccount_nr(Integer account_nr) {
        this.account_nr = account_nr;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
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
