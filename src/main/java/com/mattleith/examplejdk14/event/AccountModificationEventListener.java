package com.mattleith.examplejdk14.event;

import com.mattleith.examplejdk14.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class AccountModificationEventListener implements ApplicationListener<AccountModificationEvent> {
    private AccountService accountService;

    @Autowired
    public AccountModificationEventListener(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public void onApplicationEvent(AccountModificationEvent event) {
        accountService.applyAccountModification(event.getAccountModification());
    }
}
