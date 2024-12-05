package com.example.demo.Customer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getCustomers();
    }



    @GetMapping("/{id}")
    public Optional<Customer> getCustomer(@PathVariable Long id) {
        return customerService.getCustomerById(id);
    }



//    @PostMapping
//    public Customer registerOrUpdateCustomer(@RequestBody Customer customer) {
//        return customerService.saveCustomer(customer);
//    }

    @PostMapping
    public Customer registerOrUpdateCustomer(@ModelAttribute Customer customer) {
        return customerService.saveCustomer(customer);
    }


    @PostMapping("/delete")
    public String deleteCustomer(@RequestParam Long id) {
        customerService.deleteCustomer(id);
        return "Customer deleted successfully!";
    }

    @GetMapping("/nic/{nicNumber}")
    public Customer getCustomerByNicNumber(@PathVariable String nicNumber) {
        System.out.println("NIC Number received: " + nicNumber);
        return customerService.getCustomerByNicNumber(nicNumber);
    }

}
