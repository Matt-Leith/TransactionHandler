package com.mattleith.examplejdk14.controller;

import com.mattleith.examplejdk14.model.AccountModification;
import com.mattleith.examplejdk14.service.AccountEventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class AccountModificationEventController {
    private final AccountEventsService accountEventsService;

    @Autowired
    public AccountModificationEventController(AccountEventsService accountEventsService) {
        this.accountEventsService = accountEventsService;
    }

    @RequestMapping(value = "/accounts/events", method = RequestMethod.GET)
    @ResponseBody
    public List<AccountModification> getAllAccountEvents() {
        return accountEventsService.getAllAccountEvents();
    }
}
