package com.mr.bankur.service;

import com.mr.bankur.dao.UserDAO;
import com.mr.bankur.model.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements  UserService {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public void signUp (UserData userData){
        String password = userData.getPassword();
        userData.setPassword(passwordEncoder.encode(password));
        userDAO.signUp(userData);
    }
}
