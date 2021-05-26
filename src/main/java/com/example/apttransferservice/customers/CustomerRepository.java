package com.example.apttransferservice.customers;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Query("SELECT s FROM Customer s WHERE s.account_nr=?1 AND s.bank_name=?1")
    Optional<Customer> findCustomerByAcctNrAndBankName(String account_nr, String bank_name);
}
