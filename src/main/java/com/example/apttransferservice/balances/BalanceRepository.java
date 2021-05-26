package com.example.apttransferservice.balances;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface BalanceRepository extends JpaRepository<Balance, Long> {
    @Query("SELECT s FROM Balance s WHERE s.account_nr= ?1")
    Balance findBalanceByAcctNr(String account_nr);
}
