package com.bootcamp.demo.demo_basic_api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
@ResponseBody
public class StringController {
  //input 2 strings, return concat their first characters
  // e.g. input hello world -> hw
  @GetMapping(value = "/string/{firstword}/{secondword}")
  public String concatFirstChar(@PathVariable (value = "firstword") String x, 
  @PathVariable (value = "secondword") String y){
    return "" + x.charAt(0) + y.charAt(0); // hw
    // if char + char -> int + int -> int // "223"

  }
  
  
}
