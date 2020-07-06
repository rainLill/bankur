package com.mr.bankur.dao;

import com.mr.bankur.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Repository
public class CustomerDAO {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    public void addCustomer(Customer customer) {

        String sql = "INSERT INTO customer (first_name, last_name, age) " +
                "VALUES (:firstName, :lastName, :age)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("firstName", customer.getFirstName());
        paramMap.put("lastName", customer.getLastName());
        paramMap.put("age", customer.getAge());
        namedParameterJdbcTemplate.update(sql, paramMap);
        // lisa andmebaasi customer

    }
}