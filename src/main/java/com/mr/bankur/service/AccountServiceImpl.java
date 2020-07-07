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
    public void getBalance(String accountNumber) {

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



    @Override
    public void createAccount(int customerId) {
        //generates random accountNumber
        int max = 99999;
        int min = 10000;
        int randomAccountNumber = (int)(Math.random() * ((max - min) + 1)) + min;
        String accountNumber = "EE" + randomAccountNumber;
        //
        BigInteger balance = BigInteger.valueOf(0);
        accountDAO.createAccount(customerId, balance, accountNumber);

        //String accountNumbre =  generate account num EE + random number 5 digit
        // Input tuleb sisse anda , mis on kliendi id
        // BigInt balance  = 0
        // kutsume välja AccountDA0.createAcoount(kliendi id, konto number, balance)
    }
}
