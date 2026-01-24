package com.bootcamp.demo.demo_database.controller.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.demo_database.controller.OrderOperation;
import com.bootcamp.demo.demo_database.entity.OrderEntity;
import com.bootcamp.demo.demo_database.service.OrderService;

@RestController
public class OrderController implements OrderOperation {
  @Autowired
  private OrderService orderService;

  @Override
  public OrderEntity create(Long customerId, OrderEntity orderEntity) {
    return this.orderService.create(customerId, orderEntity);
  }
}