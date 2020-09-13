package com.mattleith.examplejdk14.service;

import com.mattleith.examplejdk14.event.AccountModificationEventPublisher;
import com.mattleith.examplejdk14.model.AccountModification;
import com.mattleith.examplejdk14.model.Transaction;
import com.mattleith.examplejdk14.respository.AccountModificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class AccountModificationService {
    private final AccountModificationRepository accountModificationRepository;
    private AccountModificationEventPublisher accountModificationEventPublisher;

    @Autowired
    public AccountModificationService(AccountModificationRepository accountModificationRepository, AccountModificationEventPublisher accountModificationEventPublisher) {
        this.accountModificationRepository = accountModificationRepository;
        this.accountModificationEventPublisher = accountModificationEventPublisher;
    }

    public void buildAccountModificationEvents(Transaction savedTransaction) {
        AccountModification fromModificationEvent = new AccountModification.Builder()
                .withAccountId(savedTransaction.getFromAccountId())
                .withChangeAmount(MakeChangeAmountNegative(savedTransaction.getAmount()))
                .build();
        AccountModification toModificationEvent = new AccountModification.Builder()
                .withAccountId(savedTransaction.getToAccountId())
                .withChangeAmount(savedTransaction.getAmount())
                .build();

        accountModificationRepository.save(fromModificationEvent);
        accountModificationRepository.save(toModificationEvent);

        accountModificationEventPublisher.publishAccountModificationEvent(fromModificationEvent);
        accountModificationEventPublisher.publishAccountModificationEvent(toModificationEvent);
    }

    private BigDecimal MakeChangeAmountNegative(BigDecimal amount) {
        return amount.multiply(new BigDecimal(-1));
    }
}
