package com.bmcd134_D288.bootstrap;

import com.bmcd134_D288.Entities.Customer;
import com.bmcd134_D288.dao.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class DataInitializer implements CommandLineRunner {

    private final CustomerRepository customerRepo;

    public DataInitializer(CustomerRepository customerRepo) {
        this.customerRepo = customerRepo;

    }

    @Override
    public void run(String... args) throws Exception {

        List<Customer> samples = List.of(

            new Customer("Alice", "Smith", "123 Maple St", "90210", "555-0101"),
            new Customer("Bob", "Jones", "456 Oak Ave", "10001", "555-0202"),
            new Customer("Carol", "Lee", "789 Pine Rd", "30303", "555-0303"),
            new Customer("Dan", "Wong", "101 Elm Blvd", "60606", "555-0404"),
            new Customer("Eve", "Patel", "202 Birch Ln", "80202", "555-0505")
);
        List<Customer> toSave = samples.stream().filter(c -> !customerRepo.existsByFirstNameAndAddress(
                c.getFirstName(), c.getAddress())).toList();
        if (!toSave.isEmpty()) {
            customerRepo.saveAll(toSave);
        }
    }
}

