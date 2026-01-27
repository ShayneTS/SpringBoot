package com.bootcamp.demo.demo_external_api.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PostDto {
  private Long id;
  private String title;
  private String body;
}
