package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.Employee;

public interface EmployeeService {

	public List<Employee> findAll();
	
	public Employee findById(int theId);
	
	public void save(Employee theEmployee);
	
	public void deleteById(int theId);

	List<Employee> findByLName(String lName);

	List<Employee> findByLName(String field, String lName);
	
}
