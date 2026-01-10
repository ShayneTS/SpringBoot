package com.bootcamp.demo.demo_basic_api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
@ResponseBody
public class CalculatorController {
  // ! API = Application Programming Interface

  // ! by default variable x in java, matching to the URL path variable x
  @GetMapping(value = "/calculator/sum/{x}/{y}")
  public int sum(@PathVariable (value = "x") Integer salary, 
      @PathVariable (value = "y") Integer bonus) { 
    // not int, why? because it can be null
    return salary + bonus;
  }

  @GetMapping(value = "/calculator/subtract/{x}/{y}")
  public int subtract(@PathVariable Integer x, @PathVariable Integer y) { 
    // not int, why? because it can be null
    return x - y;
  }
  
}
