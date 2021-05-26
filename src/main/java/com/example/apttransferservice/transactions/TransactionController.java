package com.example.apttransferservice.transactions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "api/v1/transaction")
public class TransactionController {
    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public List<Transaction> getAllTransactions() {
        return transactionService.getTransactions();
    }

    @GetMapping(path = "{account_nr}")
    public List<Transaction> getTransaction(@PathVariable("account_nr") String account_nr) {
        return transactionService.getSpecificTransactions(account_nr);
    }

    @PostMapping
    public String makeTransaction(@RequestBody Transaction transaction) {
        transactionService.addNewTransaction(transaction);
        return "Transaction was successfully made";
    }

//    @PostMapping
//    public String makeTransaction(@RequestBody Transaction transaction) {
//        transactionService.addNewTransaction(transaction);
//        if(transaction.getType().equals("Dr") || transaction.getType().equals("dr")) {
//            BalanceService.setNewBalanceAfterDr
//                    (transaction.getAccount_nr(), transaction.getAmount());
//            return "Your account has been successfully debited with " +
//                    transaction.getAmount() + " naira only";
//        }
//        else if (transaction.getType().equals("Cr") || transaction.getType().equals("cr")) {
//            BalanceService.setNewBalanceAfterCr
//                    (transaction.getAccount_nr(), transaction.getAmount());
//            return "Your account has been successfully credited with " +
//                    transaction.getAmount() + " naira only";
//        }
//        return "Please enter the correct transaction type. It is either Dr or Cr, or dr or cr";
//    }

}
