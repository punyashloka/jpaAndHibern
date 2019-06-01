package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.demo.repository.ExtendedRepositoryImpl;

@Configuration
@EnableJpaRepositories(basePackages = "com.example.demo.repository", 
  repositoryBaseClass = ExtendedRepositoryImpl.class)
public class JPAConfig {

}
