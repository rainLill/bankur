package com.mr.bankur.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

public class Customer {


    private final String firstName;
    private final String lastName;
    @Min(value = 16)
    private final int age;

    public Customer(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }
}