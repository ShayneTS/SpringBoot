package com.bootcamp.demo.demo_external_api.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PostDto {
  private Long userId; // need or not?
  private Long id;
  private String title;
  private String body;
}
