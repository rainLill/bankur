package com.mr.bankur.api;
import com.mr.bankur.model.Customer;
import com.mr.bankur.service.CustomerService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("customer")
public class CustomerController {

    //konstruktor injection (kommentaar õppimise jaoks)
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping()
    public void createCustomer(@RequestBody Customer customer) { //sisse tuleb JSONina (kommentaar õppimise jaoks)
        customerService.addCustomer(customer);
    }

    @DeleteMapping()
    public void deleteCustomer(@RequestBody Customer customer) {
        customerService.deleteCustomer(customer);
    }
}


