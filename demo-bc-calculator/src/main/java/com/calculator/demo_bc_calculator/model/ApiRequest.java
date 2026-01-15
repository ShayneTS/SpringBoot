package com.calculator.demo_bc_calculator.model;

import javax.naming.OperationNotSupportedException;
import lombok.Getter;

@Getter
public class ApiRequest {
  private String x;
  private String y;
  private Operation operation;
}
