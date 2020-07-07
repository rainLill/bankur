package com.mr.bankur.service;

import com.mr.bankur.model.Account;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;


public interface AccountService {


    BigDecimal getBalance(String accountNumber);
    void deposit(BigDecimal sum, String accountNumber);
    void withdraw( BigDecimal sum, String accountNumber);
    void transfer(BigDecimal sum, String fromAccountNumber, String toAccountNumber);
    void createAccount(int id);
}
