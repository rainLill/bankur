package com.mr.bankur.dao;

import com.mr.bankur.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

@Repository
public class AccountDAO {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    //SQL lause andmebaasi pihta depositima
    public void createAccount(int customerId, BigInteger balance, String accountNumber) {
        String sql = "INSERT INTO account (account_number, balance, customer_id)" +
                "VALUES (:accountNumber, :balance, :customerId)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("accountNumber", accountNumber);
        paramMap.put("balance", balance);
        paramMap.put("customerId", customerId);
        namedParameterJdbcTemplate.update(sql, paramMap);
    }

    public void depositMoney(String accountNumber, BigDecimal sum) {
        String sql = "UPDATE account set balance = balance + :sum " +
                "where account_number = :account_number";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("sum", sum);
        paramMap.put("account_number", accountNumber);
        namedParameterJdbcTemplate.update(sql,paramMap);
    }

    public void withdrawMoney(BigDecimal sum, String accountNumber) {
        String sql = "UPDATE account set balance = balance - :sum " +
                "where account_number = :account_number AND :sum <= balance";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("sum", sum);
        paramMap.put("account_number", accountNumber);
        namedParameterJdbcTemplate.update(sql,paramMap);
    }
}
