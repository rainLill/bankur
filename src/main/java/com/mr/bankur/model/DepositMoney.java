package com.mr.bankur.model;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMin;
import java.math.BigDecimal;

//TODO küsimus Siimule, tundub et bigdecimal valiue min ei tööta...
public class DepositMoney {
    private String accountNumber;
    @DecimalMin(value = "0.0", inclusive = false)
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
