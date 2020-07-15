package com.mr.bankur.model;

import java.math.BigDecimal;

public class WithdrawMoney {

    private String accountNumber;
    private BigDecimal sum;

    public WithdrawMoney(String accountNumber, BigDecimal sum) {
        this.accountNumber = accountNumber;
        this.sum = sum;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }
}
