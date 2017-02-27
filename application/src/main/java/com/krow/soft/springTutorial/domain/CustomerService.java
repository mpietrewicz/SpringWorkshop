package com.krow.soft.springTutorial.domain;

import com.krow.soft.springTutorial.jpa.Customer;
import com.krow.soft.springTutorial.jpa.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Iterable<Customer> findAll(){
        customerRepository.doSomethingWithExistingTransaction();
        return customerRepository.findAll();
    }

}
