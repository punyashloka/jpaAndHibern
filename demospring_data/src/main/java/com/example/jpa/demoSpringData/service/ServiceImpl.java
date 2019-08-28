package com.example.jpa.demoSpringData.service;

import com.example.jpa.demoSpringData.entity.Employee;
import com.example.jpa.demoSpringData.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.IntStream;

@Service
public class ServiceImpl {
    @Autowired
    private EmployeeRepository repository;
    public void saveEmployee(Employee emp) {
        repository.save(emp);
    }

    public void updateEmployee(Employee emp) {
        Employee emp1 = repository.findById(emp.getId()).get();
        if (Objects.nonNull(emp1)) {
            emp1.setFirstName(emp.getFirstName());
        }
    }

    public void deleteEmployeeById(Long employeeId) throws Exception {
        repository.deleteById(employeeId);
    }

    public Employee createOrUpdateEmployee(Employee entity) throws Exception {
        Optional<Employee> employee = repository.findById(entity.getId());
        if (employee.isPresent()) {
            Employee newEntity = employee.get();
            newEntity.setEmail(entity.getEmail());
            newEntity.setFirstName(entity.getFirstName());
            newEntity.setLastName(entity.getLastName());
            newEntity.setPhoneNumber(entity.getPhoneNumber());
            newEntity.setStatus(entity.getStatus());
            newEntity = repository.save(newEntity);

            return newEntity;
        } else {
            entity = repository.save(entity);

            return entity;
        }
    }

    public Employee getEmployeeById(Long id) throws Exception {
        Optional<Employee> employee = repository.findById(id);

        if (employee.isPresent()) {
            return employee.get();
        } else {
            throw new IllegalArgumentException("No employee record exist for given id");
        }
    }

    public List<Employee> getAllEmployees() {
        List<Employee> employeeList = repository.findAll();

        if (employeeList.size() > 0) {
            return employeeList;
        } else {
            return new ArrayList<Employee>();
        }
    }

    public Employee createEmployee(Employee entity) {
        entity = repository.save(entity);
        return entity;
    }

    public Boolean createBunchEmployee(final Employee entity) {
        IntStream.range(0, 1000).boxed().forEach(id -> {
            Employee emp = new Employee(entity);
            Random rand = new Random();
            BigInteger result = new BigInteger(3, rand);
            emp.setPhoneNumber(result);
            emp.setEmail((entity.getEmail() + UUID.randomUUID()).substring(0, 25));
            repository.save(emp);
        });
        return true;
    }

    public List<Employee> findByPageSize(int page, int size){
        PageRequest request = PageRequest.of(page,size);
        Page<Employee> employeeList = repository.findAll(request);
        return employeeList.getContent();
    }
    public Long  countByLastName(String lastName){
        return repository.countByLastName(lastName);
    }
}