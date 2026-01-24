package com.bootcamp.demo.demo_external_api.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import com.bootcamp.demo.demo_external_api.model.Cat;
import com.bootcamp.demo.demo_external_api.model.dto.UserDTO;

public interface HSBCOperation {
  @GetMapping(value = "/hsbc/users")
  List<UserDTO> getUsers();

  @GetMapping(value = "/hsbc/cat")
  Cat getCat();

}