package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.Employee;
import com.example.demo.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository) {
		employeeRepository = theEmployeeRepository;
	}
	
	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(int theId) {
		Optional<Employee> result = employeeRepository.findById(theId);
		
		Employee theEmployee = null;
		
		if (result.isPresent()) {
			theEmployee = result.get();
		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find employee id - " + theId);
		}
		
		return theEmployee;
	}
	
	@Override
	public List<Employee> findByLName(String lName) {
		Optional<List<Employee>> result = employeeRepository.findByLastName(lName);
		
		
		List<Employee> theEmployee = null;
		  
		  if (result.isPresent()) { theEmployee = result.get(); } 
		  else { // we didn't 
			  throw new RuntimeException("Did not find employee lastname - " +  lName); 
		  }
		 
		
		return theEmployee;
	}
	
	@Override
	public List<Employee> findByLName(String field, String lName) {
		
		
		List<Employee> emps 
        = employeeRepository.findByAttributeContainsText(field, lName);
		return emps;
	}

	@Override
	public void save(Employee theEmployee) {
		employeeRepository.save(theEmployee);
	}

	@Override
	public void deleteById(int theId) {
		employeeRepository.deleteById(theId);
	}

}






