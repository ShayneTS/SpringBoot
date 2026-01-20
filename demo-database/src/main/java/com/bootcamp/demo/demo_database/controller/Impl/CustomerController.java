package com.bootcamp.demo.demo_database.controller.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.demo_database.controller.CustomerOperation;
import com.bootcamp.demo.demo_database.entity.CustomerEntity;
import com.bootcamp.demo.demo_database.service.CustomerService;

@RestController
public class CustomerController implements CustomerOperation{
  @Autowired
  private CustomerService customerService;

  @Override
  public CustomerEntity create(CustomerEntity customerEntity){
    return this.customerService.create(customerEntity);
  }

  @Override
  public CustomerEntity getById(Long id){
    return this.customerService.getById(id);
  }

  @Override
  public void deletebyId(Long id){
    this.customerService.deleteById(id);
  }

  @Override
  public CustomerEntity updateById(Long id, CustomerEntity customerEntity){
    return this.customerService.updateById(id, customerEntity);
    }
}
