package com.krow.soft.springTutorial;

import com.krow.soft.springTutorial.jpa.Customer;
import com.krow.soft.springTutorial.jpa.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseFiller {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Bean
    public CommandLineRunner demo(final CustomerRepository repository) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {


                // save a couple of customers
                repository.save(new Customer("Jack", "Bauer"));
                repository.save(new Customer("Chloe", "O'Brian"));
                repository.save(new Customer("Kim", "Bauer"));
                repository.save(new Customer("David", "Palmer"));
                repository.save(new Customer("Michelle", "Dessler"));

                // fetch all customers
                log.info("Customers found with findAll():");
                log.info("-------------------------------");
                for (Customer customer : repository.findAll()) {
                    log.info(customer.toString());
                }
                log.info("");

                // fetch an individual customer by ID
                Customer customer = repository.findOne(1L);
                log.info("Customer found with findOne(1L):");
                log.info("--------------------------------");
                log.info(customer.toString());
                log.info("");

                // fetch customers by last name
                log.info("Customer found with findByLastName('Bauer'):");
                log.info("--------------------------------------------");
                for (Customer bauer : repository.findByLastName("Bauer")) {
                    log.info(bauer.toString());
                }
                log.info("");
            }

            ;
        };
    }

}
