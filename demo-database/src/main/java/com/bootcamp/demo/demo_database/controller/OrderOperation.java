package com.bootcamp.demo.demo_database.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.bootcamp.demo.demo_database.entity.OrderEntity;

public interface OrderOperation {
  @PostMapping(value = "/customer/{id}/order")
  OrderEntity create(@PathVariable(value = "id") Long customerId,
      @RequestBody OrderEntity orderEntity);


  // update, delete, get
}