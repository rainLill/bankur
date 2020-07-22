package com.mr.bankur.dao;

import com.mr.bankur.model.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
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
        paramMap.put("password", userData.getPassword());
        namedParameterJdbcTemplate.update(sql,paramMap);
    }
    public String getPassword (String username){
        String sql = "SELECT * FROM user_table WHERE user_name = :username";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("username", username);
        List<UserData> result = namedParameterJdbcTemplate.query(sql, paramMap, new ObjectRowMapper());
        return result.get(0).getPassword();
    }


    private class ObjectRowMapper implements RowMapper<UserData> {
        @Override
        public UserData mapRow(ResultSet resultSet, int i) throws SQLException {
            UserData userData = new UserData();
            userData.setUserName(resultSet.getString("user_name"));
            userData.setPassword(resultSet.getString("password"));
            return userData;
        }
    }
}
