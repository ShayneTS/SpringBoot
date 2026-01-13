package com.bootcamp.demo.demo_basic_api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@ResponseBody
@RequestMapping(value = "/calculator")
public class CalculatorController {
  // ! API = Application Programming Interface

  // ! by default variable x in java, matching to the URL path variable x
  @GetMapping(value = "/sum/{x}/{y}")
  public int sum(@PathVariable (value = "x") Integer salary, 
      @PathVariable (value = "y") Integer bonus) { 
    // not int, why? because it can be null
    return salary + bonus;
  }

  @GetMapping(value = "subtract/{x}/{y}")
  public int subtract(@PathVariable Integer x, @PathVariable Integer y) { 
    // not int, why? because it can be null
    return x - y;
  }
  
  // ! RequestParm
  // http://localhost:8081/calculator/multiply?x=3&y=10
  @GetMapping(value = "multiply")
  public int multiply(@RequestParam Integer x, @RequestParam Integer y) { 
    // not int, why? because it can be null
    return x * y;
  }

}
