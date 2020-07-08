package com.mr.bankur.service;

import com.mr.bankur.model.Customer;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerService {

    void addCustomer(Customer customer);
    void deleteCustomer(Customer customer);

}
