package com.mattleith.examplejdk14.service;

import com.mattleith.examplejdk14.model.AccountModification;
import com.mattleith.examplejdk14.respository.AccountModificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class AccountEventsService {
    private AccountModificationRepository accountModificationEventRepository;

    @Autowired
    public AccountEventsService(AccountModificationRepository accountModificationEventRepository) {
        this.accountModificationEventRepository = accountModificationEventRepository;
    }

    public List<AccountModification> getAllAccountEvents() {
        return (List) Optional.ofNullable(accountModificationEventRepository.findAll()).orElse(Collections.emptyList());
    }
}
