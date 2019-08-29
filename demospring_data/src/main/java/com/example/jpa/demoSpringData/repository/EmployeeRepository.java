package com.example.jpa.demoSpringData.repository;

import com.example.jpa.demoSpringData.entity.Employee;
import com.example.jpa.demoSpringData.entity.EmployeeDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import javax.persistence.Id;
import java.util.List;
import java.util.Optional;

@Repository

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    @Query("select count(id) as col_0_0_ from Employee e where lower(e.firstName)= lower(firstName)")
    long countByFirstName(@Param("firstName") String firstName);
    @Query("select count(id) as col_0_0_ from Employee e where lower(e.lastName)= lower(lastName)")
    long countByLastName(String lastname);
    long countByEmail(String lastname);

    Employee getByEmail(String email); //Throws an EmptyResultDataAccessException when the query executed does not produce a result. Throws an IllegalArgumentException when the emailAddress handed to the method is null.

    @Nullable
    Employee findByEmail(@Nullable String email);//Returns null when the query executed does not produce a result. Also accepts null as the value for emailAddress.

    Optional<Employee> findOptionalByEmail(String email);//Returns Optional.empty() when the query executed does not produce a result. Throws an IllegalArgumentException when the emailAddress handed to the method is null.

    //Query creation
    List<Employee> findByEmailAndLastName(String email, String lastName);

   //projection
    List<EmployeeView> findFirstNameByLastName(String lastName);
    EmployeeDTO findByLastName(String lastName);
}
