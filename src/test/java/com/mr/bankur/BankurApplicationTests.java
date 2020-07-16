package com.mr.bankur;

import com.mr.bankur.api.AccountController;
import com.mr.bankur.dao.AccountDAO;
import com.mr.bankur.model.Account;
import com.mr.bankur.service.MathService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
class BankurApplicationTests {

    @Autowired
    private MathService mathService;

    @Test
    void mathServiceTest() {
        assertEquals (4,mathService.multiply(2,2));
    }

    @Autowired
    private AccountController accountController;
    @Autowired
    private AccountDAO accountDAO;

    //see ei ole tglt valid test, mõistlik on ikkagi testida vastu oma datasourcu ja yampliga test datat
    //see tähendab, et sisse panne expected value staatilisena (number vms) ja siis pärida oma test datast
    //õige päring ja võrrelda
    @Test
    void accountControllerGetBalanceTest(){
        assertEquals(accountController.getBalance("EE59410"),accountDAO.getBalance("EE59410"));
    }
}
