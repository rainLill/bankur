//API on see, kuhu tulevad sisse endpointid ja
// kust edasi suunatakse service kihti (teenusesse/äriloogikasse)

package com.mr.bankur.api;

import com.mr.bankur.model.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("customer")
public class CustomerController {

    //create customer account
    @PostMapping()
    public Customer createCustomer(@RequestBody Customer customer) { //sisse tuleb JSONina
        return customer;
    }
    //delete customer account
    //get balance from account
    //deposit money to account
    //withdraw money from account
    //transfer money


}
