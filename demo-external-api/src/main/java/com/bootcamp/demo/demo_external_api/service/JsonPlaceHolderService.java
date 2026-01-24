package com.bootcamp.demo.demo_external_api.service;

import java.util.List;
import com.bootcamp.demo.demo_external_api.model.Cat;
import com.bootcamp.demo.demo_external_api.model.dto.UserDTO;

public interface JsonPlaceHolderService {
  List<UserDTO> getUsers();
  Cat getCat();
  // https://jsonplaceholder.typicode.com/users
}
