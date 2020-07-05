package com.mr.bankur.service;

import com.mr.bankur.model.Customer;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface CustomerService {

    void addCustomer(Customer customer);
    void deleteCustomer(int id);

}
