package com.example.codingshuttle.jpamapping.jpamapping.repositories;

import com.example.codingshuttle.jpamapping.jpamapping.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
}
