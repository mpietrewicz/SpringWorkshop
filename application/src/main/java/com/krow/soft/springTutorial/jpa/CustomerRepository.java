package com.krow.soft.springTutorial.jpa;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long>, CustomerRepositoryCustom {

    List<Customer> findByLastName(String lastName);

}
