package com.mr.bankur.api;

import com.mr.bankur.model.Account;
import com.mr.bankur.service.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;


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

    /*
    Esimene meetod createAccount
    - Mõtle, mis on vajalikud sisendid konto loomiseks
    - Annad muutujad edasi AccountServicile
        - AccountService peab genereerima automaatselt random kontonumbri
    - AccountServicist annad edasi AccountDAOle
     */
    @PutMapping("deposit/{account}/{sum}")
    public void depositMoney(@PathVariable("account") String accountNumber, @PathVariable("sum") BigDecimal sum) {
        accountService.deposit(sum, accountNumber);
    }
    @PutMapping("withdraw/{account}/{sum}")
    public void withdrawMoney(@PathVariable("account") String accountNumber, @PathVariable ("sum") BigDecimal sum){
        accountService.withdraw(sum, accountNumber);
    }

    /*
    deposit
    withdraw
    getBalance
    transfer
     */

}
