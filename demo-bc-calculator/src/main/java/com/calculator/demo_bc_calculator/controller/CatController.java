package com.calculator.demo_bc_calculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.calculator.demo_bc_calculator.model.Cat;

@RestController
public class CatController {
  @Autowired // injection (注入)
  private Cat cat;

  @GetMapping(value = "/cat/sum/{x}/{y}")
  public int sum(@PathVariable int x, @PathVariable int y) {
    return this.cat.sum(x, y);
  }
}
