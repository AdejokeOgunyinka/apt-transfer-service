package com.example.apttransferservice.transactions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    @Query("SELECT s FROM Transaction s WHERE s.reference=?1")
    Optional<Transaction> findTransactionByReference(Long reference);
}
