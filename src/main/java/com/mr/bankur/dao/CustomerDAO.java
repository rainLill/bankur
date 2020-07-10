package com.mr.bankur.dao;

import com.mr.bankur.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class CustomerDAO {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    public void addCustomer(Customer customer) {

        String sql = "INSERT INTO customer (first_name, last_name, age, status) " +
                "VALUES (:firstName, :lastName, :age, :status)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("firstName", customer.getFirstName());
        paramMap.put("lastName", customer.getLastName());
        paramMap.put("age", customer.getAge());
        paramMap.put("status", "active");
        namedParameterJdbcTemplate.update(sql, paramMap);
    }

    public void deleteCustomer(int id) {
        String sql1 = "UPDATE customer " +
                "SET status = 'inactive' " +
                "WHERE id = :id";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", id);
        namedParameterJdbcTemplate.update(sql1, paramMap);
    }
}