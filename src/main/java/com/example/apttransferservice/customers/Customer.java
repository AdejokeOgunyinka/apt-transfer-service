package com.example.apttransferservice.customers;

import javax.persistence.*;

@Entity
@Table
public class Customer {
    @Id
    @SequenceGenerator(
            name = "customer_sequence",
            sequenceName = "customer_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_sequence"
    )
    private Long id;
    private String full_name;
    private String account_nr;
    private String bank_name;

    public Customer() {
    }

    public Customer(Long id, String full_name, String account_nr, String bank_name) {
        this.full_name = full_name;
        this.account_nr = account_nr;
        this.bank_name = bank_name;
    }

    public Customer(String full_name, String account_nr, String bank_name) {
        this.full_name = full_name;
        this.account_nr = account_nr;
        this.bank_name = bank_name;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getAccount_nr() {
        return account_nr;
    }

    public void setAccount_nr(String account_nr) {
        this.account_nr = account_nr;
    }

    public String getBank_name() {
        return bank_name;
    }

    public void setBank_name(String bank_name) {
        this.bank_name = bank_name;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "full_name='" + full_name + '\'' +
                ", account_nr=" + account_nr +
                ", bank_name='" + bank_name + '\'' +
                '}';
    }
}
