package com.bootcamp.demo.demo_helloworld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class HelloworldController {
  
  // ! Bridge between client and server side (API)
  // server side provide API to client side to trigger
  @GetMapping(value = "/hello/java")
  public String hello() {
    // sysout is usually used for error case
    return "Hello World!!! Welcome to Spring Boot.";
  }

  @GetMapping(value = "/hello/python")
  public String goodbye() {
    return "Goodbye.";
  }
}