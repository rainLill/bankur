//API on see, kuhu tulevad sisse endpointid ja
// kust edasi suunatakse service kihti (teenusesse/äriloogikasse)

package com.mr.bankur.api;

import com.mr.bankur.model.Customer;
import com.mr.bankur.service.CustomerServiceServiceImpl;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("customer")
public class CustomerController {

    private final CustomerServiceServiceImpl customerServiceServiceImpl;

    public CustomerController(CustomerServiceServiceImpl customerServiceServiceImpl) {
        this.customerServiceServiceImpl = customerServiceServiceImpl;
    }

    //create customer account
    @PostMapping()
    public Customer createCustomer(@RequestBody Customer customer) { //sisse tuleb JSONina
        customerServiceServiceImpl.addCustomer(customer);
        return customer;
    }
    //delete customer account
    //get balance from account
    //deposit money to account
    //withdraw money from account
    //transfer money


}
