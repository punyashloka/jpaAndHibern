package com.example.demo.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.jpa.repository.JpaRepository;

@NoRepositoryBean
public interface  ExtendedRepository <T, ID extends Serializable> 
  extends JpaRepository<T, ID> {
  
    public List<T> findByAttributeContainsText(String attributeName, String text);
}