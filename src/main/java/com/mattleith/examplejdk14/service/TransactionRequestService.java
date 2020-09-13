package com.mattleith.examplejdk14.service;

import com.mattleith.examplejdk14.event.TransactionEventPublisher;
import com.mattleith.examplejdk14.model.Transaction;
import com.mattleith.examplejdk14.respository.TransactionRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionRequestService {
    private final TransactionRespository transactionRespository;
    private TransactionEventPublisher transactionEventPublisher;

    @Autowired
    public TransactionRequestService(TransactionRespository transactionRespository,
                                     TransactionEventPublisher transactionEventPublisher) {
        this.transactionRespository = transactionRespository;
        this.transactionEventPublisher = transactionEventPublisher;
    }

    public Transaction createTransaction(Transaction transaction) {
        transactionEventPublisher.publishTransactionEvent(transaction);
        return transaction;
    }

    public List<Transaction> getAllTransactions() {
        return (List) Optional.ofNullable(transactionRespository.findAll()).orElse(Collections.emptyList());
    }
}
