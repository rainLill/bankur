package com.mr.bankur.model;

import java.math.BigDecimal;

public class Account {

    private String accountNumber;
    private BigDecimal balance;
    private long customerId;

    public Account() {

    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }


    public Account(String accountNumber, BigDecimal balance, long customerId) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.customerId = customerId;
    }

    public long getCustomerId() {
        return customerId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }
}
