package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.dto.Employee;

//public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
public interface EmployeeRepository extends ExtendedRepository<Employee, Integer> {

	@Query("SELECT emp FROM Employee emp WHERE LOWER(emp.lastName) = LOWER(:name)")
	Optional<List<Employee>> findByLastName(@Param("name") String name);
	
}
