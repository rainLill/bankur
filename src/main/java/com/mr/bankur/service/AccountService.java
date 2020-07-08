package com.mr.bankur.service;

import java.math.BigDecimal;


public interface AccountService {


    BigDecimal getBalance(String accountNumber);
    void deposit(BigDecimal sum, String accountNumber);
    String withdraw(BigDecimal sum, String accountNumber);
    String transfer(BigDecimal sum, String fromAccountNumber, String toAccountNumber);
    void createAccount(int id);
}
