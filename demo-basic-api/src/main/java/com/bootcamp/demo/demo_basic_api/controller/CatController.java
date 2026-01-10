package com.bootcamp.demo.demo_basic_api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bootcamp.demo.demo_basic_api.model.Cat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@ResponseBody

public class CatController {
  @GetMapping(value = "/cat/{name}/{age}")
  public Cat create(@PathVariable String name, @PathVariable Integer age) {
      return new Cat(name, age);
  }

  // return Cat[], which has one cat only
  // API: input name and age  @GetMapping(value = "/cat/{name}/{age}")
  @GetMapping(value = "/cats/{name}/{age}")
  public Cat[] createCats(@PathVariable String name, @PathVariable Integer age) {
      return new Cat[]{new Cat(name, age)};
  }
}
// ! Class -> localdate, local date time