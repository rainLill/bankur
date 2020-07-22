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
        if (isPositive(sum)) {
            accountDAO.depositMoney(accountNumber, sum);
        } else {
            System.out.println("Insert positive sum");
        }
    }

    @Override
    public String withdraw(BigDecimal sum, String accountNumber) {
        if (isPositive(sum)) {
            if (accountDAO.getBalance(accountNumber).compareTo(sum) >= 0) {
                accountDAO.withdrawMoney(sum, accountNumber);
                return "Have your money: " + sum;
            }
            return "Not sufficient funds";
        } else {
            return "Insert positive sum";
        }
    }

    @Override
    public String transfer(BigDecimal sum, String fromAccountNumber, String toAccountNumber) {
        if (isPositive(sum)) {
            if (accountDAO.getBalance(fromAccountNumber).compareTo(sum) >= 0) {
                accountDAO.withdrawMoney(sum, fromAccountNumber);
                accountDAO.depositMoney(toAccountNumber, sum);
                return "Transfer made";
            }
            return "Not sufficient funds";
        }
        else {
            return "Insert positive sum";
        }
    }

    @Override
    public void createAccount(int customerId) {
        BigDecimal balance = BigDecimal.valueOf(0);
        accountDAO.createAccount(customerId, balance, generateAccountNumber());
    }

    @Override
    public void deleteAccount(int customerId) {
        accountDAO.deleteAccount(customerId);
    }

    @Override
    public void deleteAccount(String accountNumber) {
        accountDAO.deleteAccount(accountNumber);
    }


    private String generateAccountNumber() {
        int max = 99999;
        int min = 10000;
        int randomAccountNumber = (int) (Math.random() * ((max - min) + 1)) + min;

        if (isAccountNumberExisting("EE" + randomAccountNumber)) {
            generateAccountNumber();
            return null;
        } else {
            return "EE" + randomAccountNumber;
        }
    }

    private boolean isAccountNumberExisting(String accountNumber) {

        //TODO mõtle mingi hea viis kuidas kontrollida - yamlis: addunique constraint
        //+ if kontroll, et kood saaks aru, et uus vaja genereerida
        // postgers saab kasutada create sequence, mis on veel parem + if loogika


        return false;
    }

    private boolean isPositive(BigDecimal sum) {
        return sum.compareTo(BigDecimal.valueOf(0)) >= 0;
    }
}
