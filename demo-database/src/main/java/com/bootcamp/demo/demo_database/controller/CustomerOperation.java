package com.bootcamp.demo.demo_database.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.bootcamp.demo.demo_database.entity.CustomerEntity;

public interface CustomerOperation {
  //restful API design
  @PostMapping(value = "/customer")
  CustomerEntity create(@RequestBody CustomerEntity customerEntity);

  @GetMapping(value = "/customer")
  CustomerEntity getById(@RequestParam Long id);

  @DeleteMapping(value = "/customer")
  void deletebyId(@RequestParam Long id);

  @PutMapping(value = "/customer")
  CustomerEntity updateById(@RequestParam Long id, 
    @RequestBody CustomerEntity customerEntity);
}
