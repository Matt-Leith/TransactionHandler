package com.mattleith.examplejdk14.controller;

import com.mattleith.examplejdk14.model.Account;
import com.mattleith.examplejdk14.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class AccountController {
    private AccountService accountsService;

    @Autowired
    public AccountController(AccountService accountsService) {
        this.accountsService = accountsService;
    }

    @RequestMapping(value = "/accounts", method = RequestMethod.GET)
    @ResponseBody
    public List<Account> getAllAccounts() {
        return accountsService.getAllAccounts();
    }
}
