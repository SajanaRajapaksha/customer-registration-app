package com.example.demo.Customer;

import org.springframework.ui.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CustomerViewController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customer-form")
    public String showCustomerForm() {
        return "customer-form";
    }

    @GetMapping("/customer-list")
    public String showCustomerList(Model model) {
        model.addAttribute("customers", customerService.getCustomers());
        return "customer-list";
    }

    @GetMapping("/customer-update/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        model.addAttribute("customer", customerService.getCustomerById(id).orElseThrow(() -> new RuntimeException("Customer not found")));
        return "customer-form";
    }

//    @GetMapping("/customer-search")
//    public String searchCustomerByNicNumber(@RequestParam String nicNumber, Model model) {
//        try {
//            Customer customer = customerService.getCustomerByNicNumber(nicNumber);
//            model.addAttribute("customers", List.of(customer));
//        } catch (RuntimeException e) {
//            model.addAttribute("customers", List.of());
//            model.addAttribute("errorMessage", "No customer found with NIC Number: " + nicNumber);
//        }
//        return "customer-list";
//    }

    @GetMapping("/customer-search")
    public String searchCustomerByNicNumber(@RequestParam String nicNumber, Model model) {
        try {
            Customer customer = customerService.getCustomerByNicNumber(nicNumber);
            model.addAttribute("customer", customer);
        } catch (RuntimeException e) {
            model.addAttribute("customer", null);
            model.addAttribute("errorMessage", "No customer found with NIC Number: " + nicNumber);
        }
        return "customer-detail";
    }

}
