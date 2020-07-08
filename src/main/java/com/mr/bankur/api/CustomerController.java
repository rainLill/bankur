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

    // Todo: Miks sa küsid sisse kogu Customer data kustutamiseks.
    // Üldiselt opereeritakse olemasolevate klientidega tabeli id rea järgi. Mis customers tablis on kliendi id.
    // Samas sa küsid kustutamiseks sisse customer data ja teed customer objekti.
    // kuidas postgresql teab, milline rida kustutada, kui
    // Marvin Üürikesel vanusega 23aastat on samanimeline kaksikvend samas pangas klient?
    // kumma rea valib sis? Kas sinu või kaksikvenna oma?
    // primary keyna kasutatav element on unikaalne võti , mis aitab eristada tabeli ridu ja kui sa tead key-d siis alati jõuad õige reani.
    // nime ja vanuse järgi otsides ei ole välistatud, et samanimelisi ja vanusega on veel maal olemas.
    @DeleteMapping()
    public void deleteCustomer(@RequestBody Customer customer) {
        customerService.deleteCustomer(customer);
    }
}


