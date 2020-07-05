package com.mr.bankur.service;

import com.mr.bankur.model.Customer;

import java.math.BigDecimal;

public class CustomerServiceServiceImpl implements CustomerService {

    @Override
    public void deleteCustomer(int id) {

    }

    @Override
    public void getBalance(String accountNumber) {

    }

    @Override
    public void deposit(BigDecimal sum, String accountNumber) {

    }

    @Override
    public void withdraw(BigDecimal sum, String accountNumber) {

    }

    @Override
    public void transfer(BigDecimal sum, String fromAccountNumber, String toAccountNumber) {

    }

    @Override
    public void addCustomer(Customer customer) {
        // verify data
        // remove täpitähide , tee uus objekt
        // --> anname tulemuse DAO kätte
    }
}
