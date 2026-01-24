package com.bootcamp.demo.demo_external_api.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserDto {
  private Long id;
  private String name;
  private String email;
  private String phone;
}
