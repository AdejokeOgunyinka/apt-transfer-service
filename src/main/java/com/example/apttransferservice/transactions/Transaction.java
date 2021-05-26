package com.example.apttransferservice.transactions;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class Transaction {
    private Long reference;
    private Long amount;
    private Integer account_nr;
    private String type;

    public Transaction(Long reference, Long amount, Integer account_nr, String type) {
        this.reference = reference;
        this.amount = amount;
        this.account_nr = account_nr;
        this.type = type;
    }

    public Transaction(Long amount, Integer account_nr, String type) {
        this.amount = amount;
        this.account_nr = account_nr;
        this.type = type;
    }

    public Long getReference() {
        return reference;
    }

    public void setReference(Long reference) {
        this.reference = reference;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Integer getAccount_nr() {
        return account_nr;
    }

    public void setAccount_nr(Integer account_nr) {
        this.account_nr = account_nr;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "reference=" + reference +
                ", amount=" + amount +
                ", account_nr=" + account_nr +
                ", type='" + type + '\'' +
                '}';
    }
}
