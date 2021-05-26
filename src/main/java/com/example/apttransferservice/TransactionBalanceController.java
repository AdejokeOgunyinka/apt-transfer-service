package com.example.apttransferservice;
import com.example.apttransferservice.balances.*;
import com.example.apttransferservice.transactions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "api/v1/transaction")
public class TransactionBalanceController {
    private final BalanceService balanceService;
    private final TransactionService transactionService;

    @Autowired
    public TransactionBalanceController(TransactionService transactionService,
                                        BalanceService balanceService) {
        this.transactionService = transactionService;
        this.balanceService = balanceService;
    }

    @GetMapping
    public List<Transaction> getTransaction(@RequestParam String account_nr) {
        return transactionService.getSpecificTransactions(account_nr);
    }

    @GetMapping
    public List<Transaction> getAllTransactions() {
        return transactionService.getTransactions();
    }

    @PostMapping
    public String makeTransaction(@RequestBody Transaction transaction) {
        transactionService.addNewTransaction(transaction);
        if(transaction.getType().equals("Dr") || transaction.getType().equals("dr")) {
            balanceService.setNewBalanceAfterDr
                    (transaction.getAccount_nr(), transaction.getAmount());
            return "Your account has been successfully debited with " +
                    transaction.getAmount() + " naira only";
        }
        else if (transaction.getType().equals("Cr") || transaction.getType().equals("cr")) {
            balanceService.setNewBalanceAfterCr
                    (transaction.getAccount_nr(), transaction.getAmount());
            return "Your account has been successfully credited with " +
                    transaction.getAmount() + " naira only";
        }
        return "Please enter the correct transaction type. It is either Dr or Cr, or dr or cr";
    }
}
