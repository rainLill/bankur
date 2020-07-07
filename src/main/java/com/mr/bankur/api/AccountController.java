package com.mr.bankur.api;

import com.mr.bankur.model.Account;
import com.mr.bankur.service.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.math.BigInteger;


@RequestMapping("account")
@RestController
public class AccountController {

    //autowired springi bean
    @Autowired
    private AccountServiceImpl accountService;

    @PostMapping()
    public void createAccount(@RequestParam int id) {
        accountService.createAccount(id);
    }

    @PutMapping("deposit/{account}/{sum}")
    public void depositMoney(@PathVariable("account") String accountNumber, @PathVariable("sum") BigDecimal sum) {
        accountService.deposit(sum, accountNumber);
    }
    @PutMapping("withdraw/{account}/{sum}")
    public void withdrawMoney(@PathVariable("account") String accountNumber, @PathVariable ("sum") BigDecimal sum){
        accountService.withdraw(sum, accountNumber);
    }
    @GetMapping()
    public BigDecimal getBalance (@RequestParam String accountNumber){
        return accountService.getBalance(accountNumber);
    }

    /*
    deposit
    withdraw
    getBalance
    transfer
     */

}

    /* õppimiseks:
    Esimene meetod createAccount
    - Mõtle, mis on vajalikud sisendid konto loomiseks
    - Annad muutujad edasi AccountServicile
        - AccountService peab genereerima automaatselt random kontonumbri
    - AccountServicist annad edasi AccountDAOle
     */

//nüüd tundub, et võiks committida ja pushida?

// kui sul asjad hästi on. pane korraks server käima ja proovi , kas asjad töötavad postman
//töötab isegi :D
// vahel läheb õnneks jh :D

// aga siis commit ja push marvinisse
