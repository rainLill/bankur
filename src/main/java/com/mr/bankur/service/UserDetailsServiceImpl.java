package com.mr.bankur.service;


import com.mr.bankur.dao.UserDAO;
import com.mr.bankur.model.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    //TODO: kui ma selle infoga tahaks sisse logida, siis kust ma saan passwordi?
    @Override
    public UserDetails loadUserByUsername(String username) {
        return User.withUsername("test")
                .password(passwordEncoder.encode("test1"))
                .roles("USER").build();
    }

    @Autowired
    private UserDAO userDAO;

    public void signUp (UserData userData){
        userDAO.signUp(userData);
    }
}

