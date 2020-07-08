package com.mr.bankur.service;

import com.mr.bankur.dao.CustomerDAO;
import com.mr.bankur.model.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceServiceImpl implements CustomerService {

    private final CustomerDAO customerDAO;

    public CustomerServiceServiceImpl(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @Override
    public void addCustomer(Customer customer) {
        customerDAO.addCustomer(customer);
    }

    @Override
    public void deleteCustomer(Customer customer) {
        customerDAO.deleteCustomer(customer);
    }
}
