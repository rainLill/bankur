package com.mr.bankur.model;

import javax.validation.constraints.DecimalMin;
import java.math.BigDecimal;

public class TransferMoney {

    private String fromAccount;
    private String toAccount;
    @DecimalMin(value = "0.0")
    private BigDecimal sum;

    public TransferMoney(String fromAccount, String toAccount, BigDecimal sum) {
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.sum = sum;
    }

    public String getFromAccount() {
        return fromAccount;
    }

    public String getToAccount() {
        return toAccount;
    }

    public BigDecimal getSum() {
        return sum;
    }
}
