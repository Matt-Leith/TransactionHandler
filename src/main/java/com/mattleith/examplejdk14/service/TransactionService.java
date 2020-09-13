package com.mattleith.examplejdk14.service;

import com.mattleith.examplejdk14.model.Transaction;
import com.mattleith.examplejdk14.respository.TransactionRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    private final TransactionRespository transactionRespository;
    private final AccountModificationService accountModificationService;

    @Autowired
    public TransactionService(TransactionRespository transactionRespository,
                              AccountModificationService accountModificationService) {
        this.transactionRespository = transactionRespository;
        this.accountModificationService = accountModificationService;
    }

    public Transaction createTransaction(Transaction transaction) {
        Transaction savedTransaction = transactionRespository.save(transaction);
        accountModificationService.buildAccountModificationEvents(savedTransaction);
        return savedTransaction;
    }
}
