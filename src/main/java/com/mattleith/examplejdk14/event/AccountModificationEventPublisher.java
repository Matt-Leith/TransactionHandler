package com.mattleith.examplejdk14.event;

import com.mattleith.examplejdk14.model.AccountModification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class AccountModificationEventPublisher {
    private ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    public AccountModificationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public void publishAccountModificationEvent(AccountModification accountModification) {
        AccountModificationEvent accountModificationEvent = new AccountModificationEvent(this, accountModification);
        applicationEventPublisher.publishEvent(accountModificationEvent);
    }
}
