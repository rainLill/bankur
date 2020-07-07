package com.mr.bankur.dao;

import com.mr.bankur.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
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

    public BigDecimal getBalance(String accountNumber) {
        String sql = "SELECT * FROM account WHERE account_number = :account_number";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("account_number", accountNumber);
        List<Account> result = namedParameterJdbcTemplate.query(sql, paramMap, new ObjectRowMapper());
        return result.get(0).getBalance();
    }

    private class ObjectRowMapper implements RowMapper<Account>{
        @Override
        public Account mapRow(ResultSet resultSet, int i) throws SQLException {

            Account account = new Account();
            account.setAccountNumber(resultSet.getString("account_number"));
            account.setBalance(resultSet.getBigDecimal("balance"));
            return account;
        }
    }
}


// mis asja sa just ennem tegid ?
//loogika oli selles, et kuna tahan objectrowmapperiga teha uut accounti, aga Accounounti konstruktoris olid vajalikud osad,
// siis tegin sellise konstruktori, mis ei võta muutujaid sisse ja neid saab settida selles mapperis

// see mis sa tegid on defaultConstructor
// kui sa konstructorit ei tee , siis s java  teeb ise sellise asja vaikimsi
// seega kustuta see ära ja kõik on hästi , kui sul getterid ja setterid on paigas

//kustuna ära, aga siis oli punane :D

//kas näed?