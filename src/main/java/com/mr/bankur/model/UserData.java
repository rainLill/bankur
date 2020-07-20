package com.mr.bankur.model;

public class UserData {

    private String userName;
    private String password;

    public UserData(String userName, String password) {
        this.userName = userName;
        //TODO siia saaks teha valideerimise; et keerukust tõsta
        this.password = password;
    }

    public UserData() {
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}


