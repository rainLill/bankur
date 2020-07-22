package com.mr.bankur.model;

import javax.validation.Valid;
import java.math.BigDecimal;

//TODO küsimus Siimule, tundub et bigdecimal valiue min ei tööta...vastus - jah ei tööta,
//tuleb ilmselt teha mingi "if" või mingi veel ägedam meetod
public class DepositMoney {
    private String accountNumber;
    private BigDecimal sum;

    public DepositMoney(String accountNumber, BigDecimal sum) {
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
