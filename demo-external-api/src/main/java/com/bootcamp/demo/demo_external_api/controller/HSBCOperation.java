package com.bootcamp.demo.demo_external_api.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import com.bootcamp.demo.demo_external_api.dto.PostDto;
import com.bootcamp.demo.demo_external_api.dto.UserDto;
import com.bootcamp.demo.demo_external_api.model.Cat;

public interface HSBCOperation {
  @GetMapping(value = "/hsbc/users")
  List<UserDto> getUsers();

  @GetMapping(value = "/hsbc/posts")
  List<PostDto> getPosts();

  @GetMapping(value = "/hsbc/cat")
  Cat getCat();

  

}