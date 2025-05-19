package com.bmcd134_D288.dao;

import com.bmcd134_D288.Entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface CountryRepository extends JpaRepository<Country,Long> {
}
