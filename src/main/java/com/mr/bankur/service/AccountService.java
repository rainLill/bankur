package com.mr.bankur.service;

import org.springframework.stereotype.Repository;

import java.math.BigDecimal;


public interface AccountService {


    void getBalance(String accountNumber);
    void deposit(BigDecimal sum, String accountNumber);
    void withdraw( BigDecimal sum, String accountNumber);
    void transfer(BigDecimal sum, String fromAccountNumber, String toAccountNumber);
}
