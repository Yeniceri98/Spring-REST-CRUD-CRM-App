package com.springdemo.rest;

import com.springdemo.entity.Customer;
import com.springdemo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

    // Autowire the CustomerService
    @Autowired
    private CustomerService customerService;        // Injects the dependency

    // Add mapping for GET /customers
    @GetMapping("/customers")
    public List<Customer> getCustomers() {
        return customerService.getCustomers();      // REST Controller ---> Service ---> DAO ---> Hibernate
    }

    // Add mapping for GET single customer
    @GetMapping("/customers/{customerId}")
    public Customer getSingleCustomer(@PathVariable int customerId) {

        Customer customer = customerService.getCustomerById(customerId);

        if (customer == null) {
            throw new CustomerNotFoundException("Customer with the id of " + customerId + " is not found!");
        }

        return customer;
    }
}

/*
    NOT: config, entity, service, dao, entity paketlerindeki classları önceki DatabaseWebApp projesinden aldık. O projede Controller classı varken, burada REST Controller classını kullandık
*/