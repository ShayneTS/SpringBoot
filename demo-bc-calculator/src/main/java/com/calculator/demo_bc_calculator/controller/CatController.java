package com.calculator.demo_bc_calculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.calculator.demo_bc_calculator.model.Cat;

// ! CatController Bean depends on Cat Bean.
@RestController
public class CatController {
  // ! Refer this reference to the bean in spring context
  // if not use Spring, then skip line 14, 15
  @Autowired // injection (注入)
  private Cat cat; // address

  @GetMapping(value = "/cat/sum/{x}/{y}")
  public int sum(@PathVariable int x, @PathVariable int y) {
    return this.cat.sum(x, y); // ! NPE if Cat Bean is not ready
    // if not use Spring, will look like:
    // return new Cat().sum(x,y);
  }
}
