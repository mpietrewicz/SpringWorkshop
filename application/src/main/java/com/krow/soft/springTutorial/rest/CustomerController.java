package com.krow.soft.springTutorial.rest;

import com.google.common.collect.Lists;
import com.krow.soft.springTutorial.domain.CustomerService;
import com.krow.soft.springTutorial.jpa.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @RequestMapping("/customers")
    @ResponseBody
    List<Customer> allCustomer() {
        Iterable<Customer> all = customerService.findAll();
        return Lists.newArrayList(all);
    }





}