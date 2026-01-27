package com.bootcamp.demo.demo_external_api.mapper;

import com.bootcamp.demo.demo_external_api.entity.PostEntity;
import com.bootcamp.demo.demo_external_api.entity.UserEntity;
import com.bootcamp.demo.demo_external_api.model.dto.PostDTO;
import com.bootcamp.demo.demo_external_api.model.dto.UserDTO;

public class EntityMapper {
  public UserEntity map(UserDTO userDTO) {
    return UserEntity.builder() //
        .username(userDTO.getUsername()) //
        .street(userDTO.getAddress().getStreet()) //
        .companyName(userDTO.getCompany().getName()) //
        .build();
  }

  public PostEntity map(PostDTO postDTO) {
    return PostEntity.builder() //
        .title(postDTO.getTitle()) //
        .body(postDTO.getBody()) //
        .build();
  }
}
