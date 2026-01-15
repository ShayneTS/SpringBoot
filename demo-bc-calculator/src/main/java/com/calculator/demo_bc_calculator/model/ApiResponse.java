package com.calculator.demo_bc_calculator.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ApiResponse {
  private String x;
  private String y;
  private String operation;
  private String result;
}
