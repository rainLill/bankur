package com.mr.bankur.service;

import com.mr.bankur.dao.AccountDAO;
import com.mr.bankur.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Random;

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
        //saadame ibani ja sumi edasi DAOsse, kus updateme SQLiga andmebaasi
        accountDAO.depositMoney(accountNumber, sum);
    }


    @Override
    public void withdraw(BigDecimal sum, String accountNumber) {
        accountDAO.withdrawMoney(sum, accountNumber);
        //hetkel on SQLi päringus "if" sees, kas on piisavalt raha, et välja võtta;
        //selle kontrolli peaks tglt siia tooma......task Marvinile
    }

    @Override
    public void transfer(BigDecimal sum, String fromAccountNumber, String toAccountNumber) {

    }
// kuidas see on ? Kas on loetav ja selge ?
    //lühem ja ilusam on küll, arusaadav ka
    // sisuliselt kehtib ka selline reegel, et iga ülesande jaoks oma meetod. Koodi analüsiaatorid
    /*
    VAjutasin alt + 7  ehk structure view
    ctrl + F12 on sama aga pop up aknas. näitab ära sulle kõik meetodid ja klassi muutujad.
    üks kiire meetod kuidas liikuda ringi

    aga nüüd ma teen check out su asjale

     */


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
