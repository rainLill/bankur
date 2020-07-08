//API on see, kuhu tulevad sisse endpointid ja
// kust edasi suunatakse service kihti (teenusesse/äriloogikasse)
package com.mr.bankur.api;
import com.mr.bankur.model.Customer;
import com.mr.bankur.service.CustomerServiceServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("customer")
public class CustomerController {

    //konstruktor injection (kommentaar õppimise jaoks)
    private final CustomerServiceServiceImpl customerServiceServiceImpl;

    public CustomerController(CustomerServiceServiceImpl customerServiceServiceImpl) {
        this.customerServiceServiceImpl = customerServiceServiceImpl;
    }

    @PostMapping()
    public void createCustomer(@RequestBody Customer customer) { //sisse tuleb JSONina (kommentaar õppimise jaoks)
        customerServiceServiceImpl.addCustomer(customer);
    }

    @DeleteMapping()
    public void deleteCustomer(@RequestBody Customer customer) {
        customerServiceServiceImpl.deleteCustomer(customer);
    }
}


