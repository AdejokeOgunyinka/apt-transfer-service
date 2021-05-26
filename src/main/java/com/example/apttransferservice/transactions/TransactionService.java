package com.example.apttransferservice.transactions;

import javassist.bytecode.StackMapTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionService (TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<Transaction> getTransactions() {
        return transactionRepository.findAll();
    }

    public void addNewTransaction (Transaction transaction){
        Optional<Transaction> transactionOptional = transactionRepository.findTransactionByReference
                (transaction.getReference());
        if (transactionOptional.isPresent()){
            throw new IllegalStateException
                    ("This transaction has already been performed. Avoid duplicate");
        }
        transactionRepository.save(transaction);
    }

    public void deleteTransaction (Long reference){
        boolean exists = transactionRepository.existsById(reference);
        if(!exists){
            throw new IllegalStateException("This transaction does not exist.");
        }
        transactionRepository.deleteById(reference);
    }
}
