package com.bmcd134_D288.bootstrap;

import com.bmcd134_D288.Entities.Customer;
import com.bmcd134_D288.dao.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class DataInitializer implements CommandLineRunner {

    private final CustomerRepository customerRepo;

    public DataInitializer(CustomerRepository customerRepo) {
        this.customerRepo = customerRepo;

    }

    @Override
    public void run(String... args) throws Exception {

        if (customerRepo.count() == 0) {

            Customer c1 = new Customer("Alice", "Smith", "123 Maple St", "90210", "555-0101");
            Customer c2 = new Customer("Bob", "Jones", "456 Oak Ave", "10001", "555-0202");
            Customer c3 = new Customer("Carol", "Lee", "789 Pine Rd", "30303", "555-0303");
            Customer c4 = new Customer("Dan", "Wong", "101 Elm Blvd", "60606", "555-0404");
            Customer c5 = new Customer("Eve", "Patel", "202 Birch Ln", "80202", "555-0505");

            customerRepo.save(c1);
            customerRepo.save(c2);
            customerRepo.save(c3);
            customerRepo.save(c4);
            customerRepo.save(c5);

        }
    }
}

