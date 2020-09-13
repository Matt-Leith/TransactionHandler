package com.mattleith.examplejdk14.event;

import com.mattleith.examplejdk14.model.AccountModification;
import org.springframework.context.ApplicationEvent;

public class AccountModificationEvent extends ApplicationEvent {
    private AccountModification accountModification;

    public AccountModificationEvent(Object source, AccountModification accountModification) {
        super(source);
        this.accountModification = accountModification;
    }

    public AccountModification getAccountModification() {
        return accountModification;
    }
}
