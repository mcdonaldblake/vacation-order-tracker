package com.bmcd134_D288.dao;

import com.bmcd134_D288.Entities.Division;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
public interface DivisionRepository extends JpaRepository<Division,Long> {
}
