package com.mr.bankur.service;

import com.mr.bankur.dao.CustomerDAO;
import com.mr.bankur.model.Customer;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
@Service
public class CustomerServiceServiceImpl implements CustomerService {

    private final CustomerDAO customerDAO;

    public CustomerServiceServiceImpl(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    @Override
    public void addCustomer(Customer customer) {
        // verify data
        // remove täpitähide , tee uus objekt
        // --> anname tulemuse DAO kätte

        // eelnevalt võib teha kontroller või muid tegevusi antud sisendandmetega või objektidga

        customerDAO.addCustomer(customer);

    }

    @Override
    public void deleteCustomer(int id) {

    }

}
