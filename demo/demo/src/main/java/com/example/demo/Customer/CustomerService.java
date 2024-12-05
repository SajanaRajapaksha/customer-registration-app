package com.example.demo.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getCustomers(){
      return customerRepository.findAll();
    }

//    public Customer saveCustomer(Customer customer) {
//        if (customerRepository.existsByLoginUsername(customer.getLoginUsername())) {
//            throw new IllegalArgumentException("Username already exists!");
//        }
//        if (customerRepository.existsByNicNumber(customer.getNicNumber())) {
//            throw new IllegalArgumentException("User with entered NIC already exists!");
//        }
//        customer.setRegisteredDate(LocalDate.now());
//
//        return customerRepository.save(customer);
//    }

    public Customer saveCustomer(Customer customer) {
        if (customer.getId() == null) {
            if (customerRepository.existsByLoginUsername(customer.getLoginUsername())) {
                throw new IllegalArgumentException("Username already exists!");
            }
            if (customerRepository.existsByNicNumber(customer.getNicNumber())) {
                throw new IllegalArgumentException("User with entered NIC already exists!");
            }
            customer.setRegisteredDate(LocalDate.now());
        }
        return customerRepository.save(customer);
    }

    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    public Customer getCustomerByNicNumber(String nicNumber) {
        System.out.println("Searching for NIC Number: " + nicNumber);
        return customerRepository.findByNicNumber(nicNumber)
                .orElseThrow(() -> new RuntimeException("Customer not found with NIC Number: " + nicNumber));
    }
}
