package com.bootcamp.demo.demo_external_api.mapper;

import com.bootcamp.demo.demo_external_api.dto.PostDto;
import com.bootcamp.demo.demo_external_api.dto.UserDto;
import com.bootcamp.demo.demo_external_api.model.dto.PostDTO;
import com.bootcamp.demo.demo_external_api.model.dto.UserDTO;

public class DtoMapper {
  public UserDto map(UserDTO userDTO) {
    return UserDto.builder() //
        .id(userDTO.getId()) //
        .name(userDTO.getName()) //
        .email(userDTO.getEmail()) //
        .phone(userDTO.getPhone()) //
        .build();
  }

    public PostDto map(PostDTO postDTO) {
    return PostDto.builder() //
        .id(postDTO.getId()) //
        .title(postDTO.getTitle())//
        .body(postDTO.getBody()) //
        .build();
  }
}