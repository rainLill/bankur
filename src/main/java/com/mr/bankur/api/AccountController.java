package com.mr.bankur.api;

import com.mr.bankur.model.Account;
import com.mr.bankur.model.DepositMoney;
import com.mr.bankur.model.TransferMoney;
import com.mr.bankur.model.WithdrawMoney;
import com.mr.bankur.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import java.math.BigDecimal;


@Validated
@RestController
@RequestMapping("account")
public class AccountController {


    //õppimiseks: pathvariable on mingi viide millegile, aga mitte kunagi äriloogiline sisend
    //sisendid, mis on muutujad vaja sisse anda requestparametriga, isegi requestbodyga oleks parem

    //autowired springi bean dependency injection (õppimise jaoks comment)
    @Autowired
    private AccountService accountService;

    @PostMapping({"{customer_id}"})
    public void createAccount(@PathVariable ("customer_id") int customerId) {
        accountService.createAccount(customerId);
    }

    @DeleteMapping()
    public void deleteAccount(@RequestBody Account account) {
        accountService.deleteAccount(account.getAccountNumber());
    }

    @PutMapping("deposit")
    public void depositMoney(@RequestBody DepositMoney depositMoney) {
        accountService.deposit(depositMoney.getSum(), depositMoney.getAccountNumber());
    }

    @PutMapping("withdraw")
    public String withdrawMoney(@RequestBody WithdrawMoney withdrawMoney) {
        return accountService.withdraw(withdrawMoney.getSum(), withdrawMoney.getAccountNumber());
    }

    @GetMapping()
    public BigDecimal getBalance(@RequestParam ("account") String accountNumber) {
        return accountService.getBalance(accountNumber);
    }

    @PutMapping("transfer")
    public String transferMoney(@RequestBody TransferMoney transferMoney) {
        return accountService.transfer(transferMoney.getSum(), transferMoney.getFromAccount(), transferMoney.getToAccount());
    }
}


