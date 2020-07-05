package com.mr.bankur.service;

import com.mr.bankur.model.Customer;

import java.math.BigDecimal;

public interface CustomerService {

    void addCustomer(Customer customer);
    void deleteCustomer(int id);
    void getBalance(String accountNumber);
    void deposit(BigDecimal sum, String accountNumber);
    void withdraw( BigDecimal sum, String accountNumber);
    void transfer(BigDecimal sum, String fromAccountNumber, String toAccountNumber);

}
