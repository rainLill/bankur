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
    public void deleteCustomer(int id) {
        customerDAO.deleteCustomer(id);
        //siit tahaks kustutada ka kõik selle kliendi kontod, kui klient ise kaob...TODO
    }
}
