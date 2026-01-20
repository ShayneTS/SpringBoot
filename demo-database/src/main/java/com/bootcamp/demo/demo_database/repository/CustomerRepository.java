package com.bootcamp.demo.demo_database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bootcamp.demo.demo_database.entity.CustomerEntity;

// ! select, update, insert, delete
@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long>{
  
}
