package com.bootcamp.demo.demo_external_api.model.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PostDTO {
  private Long userId;
  private Long id;
  private String title;
  private String body;
}
