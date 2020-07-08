package com.mr.bankur.api;

import com.mr.bankur.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;


@RequestMapping("account")
@RestController
public class AccountController {

    //TODO: Miks sa kasutad osade endpointide (meetodite sisendite puhul) @RequestParam ja osade puhul @PathVariable ? Mis su loogika selles on?

    //autowired springi bean dependency injection (õppimise jaoks comment)
    @Autowired
    private AccountService accountService;

    @PostMapping()
    public void createAccount(@RequestParam int id) {
        accountService.createAccount(id);
    }

    @PutMapping("deposit/{account}/{sum}")
    public void depositMoney(@PathVariable("account") String accountNumber, @PathVariable("sum") BigDecimal sum) {
        accountService.deposit(sum, accountNumber);
    }

    @PutMapping("withdraw/{account}/{sum}")
    public String withdrawMoney(@PathVariable("account") String accountNumber, @PathVariable("sum") BigDecimal sum) {
        return accountService.withdraw(sum, accountNumber);
    }

    @GetMapping()
    public BigDecimal getBalance(@RequestParam String accountNumber) {
        return accountService.getBalance(accountNumber);
    }

    @PutMapping("transfer/{fromAccount}/{toAccount}/{sum}")
    public String transferMoney(@PathVariable("fromAccount") String fromAccount, @PathVariable("toAccount") String toAccount, @PathVariable("sum") BigDecimal sum) {
        return accountService.transfer(sum, fromAccount, toAccount);
    }
}

