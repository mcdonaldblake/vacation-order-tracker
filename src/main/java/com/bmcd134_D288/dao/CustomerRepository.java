package com.bmcd134_D288.dao;

import com.bmcd134_D288.Entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    boolean existsByFirstNameAndAddress(String firstName, String address);
}
