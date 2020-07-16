package com.mr.bankur.api;

import com.mr.bankur.model.UserData;
import com.mr.bankur.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;

    @PutMapping("/signUp")
    public void signUp (@RequestBody UserData userData){
        userDetailsServiceImpl.signUp(userData);
    }

}

