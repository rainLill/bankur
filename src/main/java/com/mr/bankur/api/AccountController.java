package com.mr.bankur.api;

import com.mr.bankur.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Min;
import java.math.BigDecimal;


@RequestMapping("account")
@RestController
public class AccountController {

    //TODO: Miks sa kasutad osade endpointide (meetodite sisendite puhul) @RequestParam ja osade puhul @PathVariable ? Mis su loogika selles on?
    //TODO: kõik kus kasutad "sum" on vaja requestparammi peale, veel parem requesBodyga
    //TODO seega tuleb kõik ümber teha ja panna peale validaatorid, kus vaja

    //õppimiseks: pathvariable on mingi viide millegile, aga mitte kunagi äriloogiline sisend
    //sisendid, mis on muutujad vaja sisse anda requestparametriga, isegi requestbodyga oleks parem

    //autowired springi bean dependency injection (õppimise jaoks comment)
    @Autowired
    private AccountService accountService;

    @PostMapping()
    public void createAccount(@RequestParam int customerId) {
        accountService.createAccount(customerId);
    }

    @DeleteMapping()
    public void deleteAccount(@RequestParam String accountNumber){
        accountService.deleteAccount(accountNumber);
    }


    //TODO: vajalik lisada kontroll, et sisestatud sum oleks positiivne arv, muidu saab koodi trikitada
    // kas seda saab ka @Validiga teha või kuna ta pole klassi muutuja, siis vaja äriloogikas kontrollida?


    @PutMapping("deposit/{account}/{sum}")
    public void depositMoney(@PathVariable("account") String accountNumber, @Min(value = 0) @PathVariable("sum") BigDecimal sum) {
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

