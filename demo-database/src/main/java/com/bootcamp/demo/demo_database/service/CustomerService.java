package com.bootcamp.demo.demo_database.service;

import com.bootcamp.demo.demo_database.entity.CustomerEntity;

public interface CustomerService {
  // Post
  CustomerEntity create(CustomerEntity customerEntity);
  // GetById
  CustomerEntity getById(Long id);
  // DeleteById
  void deleteById(Long id);

  // PutById
  CustomerEntity updateById(Long id, CustomerEntity customerEntity);
}
