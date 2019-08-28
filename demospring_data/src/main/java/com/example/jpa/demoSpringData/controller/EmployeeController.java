package com.example.jpa.demoSpringData.controller;

import com.example.jpa.demoSpringData.entity.Employee;
import com.example.jpa.demoSpringData.service.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Employees")
public class EmployeeController
{
    @Autowired
    private ServiceImpl service;

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> list = service.getAllEmployees();

        return new ResponseEntity<List<Employee>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id)
            throws Exception {
        Employee entity = service.getEmployeeById(id);

        return new ResponseEntity<Employee>(entity, new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Employee> createOrUpdateEmployee(Employee Employee)
            throws Exception {
        Employee updated = service.createOrUpdateEmployee(Employee);
        return new ResponseEntity<Employee>(updated, new HttpHeaders(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteEmployeeById(@PathVariable("id") Long id)
            throws Exception {
        service.deleteEmployeeById(id);
        return HttpStatus.FORBIDDEN;
    }

}
