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

    //autowired springi bean dependency injection (õppimise jaoks comment)
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

