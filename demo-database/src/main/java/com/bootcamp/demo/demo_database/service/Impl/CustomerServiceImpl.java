package com.bootcamp.demo.demo_database.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bootcamp.demo.demo_database.entity.CustomerEntity;
import com.bootcamp.demo.demo_database.repository.CustomerRepository;
import com.bootcamp.demo.demo_database.service.CustomerService;

@Service // ! Bean
public class CustomerServiceImpl implements CustomerService {
  @Autowired //inject repository layer
  private CustomerRepository customerRepository; //service always autowire repository
  @Override
  public CustomerEntity create(CustomerEntity customerEntity){
    return this.customerRepository.save(customerEntity); // auto generate id
  }

  // GetById
  @Override
  public CustomerEntity getById(Long id){
    return this.customerRepository.findById(id).orElse(null);
  }

  // DeleteById
  @Override
  public void deleteById(Long id){
    this.customerRepository.deleteById(id);
  }

  // PutById
  @Override
  public CustomerEntity updateById(Long id, CustomerEntity customerEntity){
    CustomerEntity entity = this.customerRepository.findById(id).orElse(null);
    if (entity != null) {
      entity.setDob(customerEntity.getDob());
      entity.setNames(customerEntity.getNames());
      return this.customerRepository.save(entity);
    }
    return null;
  }
}
