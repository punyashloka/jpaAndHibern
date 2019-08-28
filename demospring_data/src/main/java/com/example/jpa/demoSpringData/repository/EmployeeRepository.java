package com.example.jpa.demoSpringData.repository;

import com.example.jpa.demoSpringData.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
