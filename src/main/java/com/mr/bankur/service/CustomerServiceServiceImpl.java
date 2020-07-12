package com.mr.bankur.service;

import com.mr.bankur.dao.AccountDAO;
import com.mr.bankur.dao.CustomerDAO;
import com.mr.bankur.model.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceServiceImpl implements CustomerService {

    private final CustomerDAO customerDAO;
    private final AccountDAO accountDAO;

    public CustomerServiceServiceImpl(CustomerDAO customerDAO, AccountDAO accountDAO) {
        this.customerDAO = customerDAO;
        this.accountDAO = accountDAO;
    }

    @Override
    public void addCustomer(Customer customer) {
        customerDAO.addCustomer(customer);
    }

    @Override
    public void deleteCustomer(int id) {
        customerDAO.deleteCustomer(id);
        accountDAO.deleteAccount(id);
    }
}
