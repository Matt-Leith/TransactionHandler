package com.mattleith.examplejdk14.service;

import com.mattleith.examplejdk14.model.Account;
import com.mattleith.examplejdk14.model.AccountModification;
import com.mattleith.examplejdk14.respository.query.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    private AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void applyAccountModification(AccountModification accountModification) {
        Account account = accountRepository.findById(accountModification.getAccountId())
                .orElse(new Account.Builder()
                        .withAccountId(accountModification.getAccountId())
                        .withAmount(new BigDecimal("0"))
                        .build());

        account.setAmount(account.getAmount().add(accountModification.getChangeAmount()));
        accountRepository.save(account);
    }

    public List<Account> getAllAccounts() {
        return (List) Optional.ofNullable(accountRepository.findAll()).orElse(Collections.emptyList());
    }
}
