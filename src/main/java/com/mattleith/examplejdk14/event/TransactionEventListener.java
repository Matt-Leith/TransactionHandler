package com.mattleith.examplejdk14.event;

import com.mattleith.examplejdk14.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class TransactionEventListener implements ApplicationListener<TransactionEvent> {
    private final TransactionService transactionsService;

    @Autowired
    public TransactionEventListener(TransactionService transactionsService) {
        this.transactionsService = transactionsService;
    }

    @Override
    public void onApplicationEvent(TransactionEvent event) {
        transactionsService.createTransaction(event.getTransaction());
    }
}
