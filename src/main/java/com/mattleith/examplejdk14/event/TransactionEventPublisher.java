package com.mattleith.examplejdk14.event;

import com.mattleith.examplejdk14.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class TransactionEventPublisher {
    private ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    public TransactionEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void publishTransactionEvent(Transaction transaction) {
        TransactionEvent transactionEvent = new TransactionEvent(this, transaction);
        applicationEventPublisher.publishEvent(transactionEvent);
    }
}
