package com.example.codingshuttle.jpamapping.jpamapping.repositories;

import com.example.codingshuttle.jpamapping.jpamapping.entities.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long> {
}
