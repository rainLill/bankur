package com.mr.bankur.service;
import com.mr.bankur.dao.AccountDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.math.BigInteger;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDAO accountDAO;

    @Override
    public BigDecimal getBalance(String accountNumber) {
        return accountDAO.getBalance(accountNumber);
    }

    @Override
    public void deposit(BigDecimal sum, String accountNumber) {
        accountDAO.depositMoney(accountNumber, sum);
    }

    @Override
    public String withdraw(BigDecimal sum, String accountNumber) {
        if (accountDAO.getBalance(accountNumber).compareTo(sum) >= 0) {
            accountDAO.withdrawMoney(sum, accountNumber);
            return "Have your money: " + sum;
        }
        return "Not sufficient funds";

    }

    @Override
    public String transfer(BigDecimal sum, String fromAccountNumber, String toAccountNumber) {
        if (accountDAO.getBalance(fromAccountNumber).compareTo(sum) >= 0){
            accountDAO.withdrawMoney(sum, fromAccountNumber);
            accountDAO.depositMoney(toAccountNumber, sum);
            return "Transfer made";
        }
        return "Not sufficient funds";
    }

// TODO: Kas andmebaasis on balance BigInteger või BigDecimal? siin on kasutusel BigInteger , kui ülal kasutad raha jaoks BigDecimal.
    @Override
    public void createAccount(int customerId) {
        BigInteger balance = BigInteger.valueOf(0);
        accountDAO.createAccount(customerId, balance, generateAccountNumber());
    }

    private String generateAccountNumber() {
        int max = 99999;
        int min = 10000;
        int randomAccountNumber = (int)(Math.random() * ((max - min) + 1)) + min;
        return "EE" + randomAccountNumber;
    }
}
