package com.mattleith.examplejdk14.controller;

import com.mattleith.examplejdk14.model.Transaction;
import com.mattleith.examplejdk14.service.TransactionRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TransactionController {
    private TransactionRequestService transactionRequestService;

    @Autowired
    public TransactionController(TransactionRequestService transactionRequestService) {
        this.transactionRequestService = transactionRequestService;
    }

    @RequestMapping(value = "/transactions", method = RequestMethod.GET)
    @ResponseBody
    public List<Transaction> getAllTransactions() {
        return transactionRequestService.getAllTransactions();
    }

    @RequestMapping(value = "/transactions", method = RequestMethod.POST)
    @ResponseBody
    public Transaction createTransaction(Transaction transaction) {
        return transactionRequestService.createTransaction(transaction);
    }
}
