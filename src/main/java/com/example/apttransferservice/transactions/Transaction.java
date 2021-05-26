package com.example.apttransferservice.transactions;

import javax.persistence.*;

@Entity
@Table
public class Transaction {
    @Id
    @SequenceGenerator(
            name = "transaction_sequence",
            sequenceName = "transaction_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "transaction_sequence"
    )
    private Long reference;
    private Double amount;
    private String account_nr;
    private String type;

    public Transaction() {
    }

    public Transaction(Long reference, Double amount, String account_nr, String type) {
        this.reference = reference;
        this.amount = amount;
        this.account_nr = account_nr;
        this.type = type;
    }

    public Transaction(Double amount, String account_nr, String type) {
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

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getAccount_nr() {
        return account_nr;
    }

    public void setAccount_nr(String account_nr) {
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
