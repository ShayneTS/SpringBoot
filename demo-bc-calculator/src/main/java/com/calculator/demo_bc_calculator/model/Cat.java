package com.calculator.demo_bc_calculator.model;

import org.springframework.stereotype.Component;

// stateless (c1.sum(3,7))
@Component // ! Create a bean of Cat

public class Cat {
  public int sum(int x, int y){
    return x + y;
  }
}
