package com.bootcamp.demo.demo_database.service;

import com.bootcamp.demo.demo_database.entity.OrderEntity;

public interface OrderService {
  // Post
  OrderEntity create(Long customerId, OrderEntity orderEntity);
}
