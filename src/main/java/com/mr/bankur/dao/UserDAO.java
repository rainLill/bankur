package com.mr.bankur.dao;

import com.mr.bankur.model.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserDAO {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public void signUp (UserData userData){
        String sql = "INSERT INTO user_table (user_name, password) values (:userName, :password)";
        Map<String, Object > paramMap = new HashMap<>();
        paramMap.put("userName", userData.getUserName());
        paramMap.put("password", passwordEncoder.encode(userData.getPassword()));
        namedParameterJdbcTemplate.update(sql,paramMap);
    }
}
