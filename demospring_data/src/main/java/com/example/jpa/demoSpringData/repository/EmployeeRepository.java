package com.example.jpa.demoSpringData.repository;

import com.example.jpa.demoSpringData.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;
@Repository
@NoRepositoryBean
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("select count(id) as col_0_0_ from Employee e where lower(e.firstName)= lower(firstName)")
    long countByFirstName(@Param("firstName") String firstName);
    @Query("select count(id) as col_0_0_ from Employee e where lower(e.lastName)= lower(lastName)")
    long countByLastName(String lastname);
    long countByEmail(String lastname);
}
