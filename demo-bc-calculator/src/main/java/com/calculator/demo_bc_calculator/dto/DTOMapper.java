package com.calculator.demo_bc_calculator.dto;

import com.calculator.demo_bc_calculator.model.ApiRequest;
import com.calculator.demo_bc_calculator.model.ApiResponse;
import jdk.dynalink.Operation;

public class DTOMapper {
  public static ApiResponse map(String x, String y, Operation operation, String result) {
    return ApiResponse.builder() //
      .x(x) //
      .y(y) //
      .operation(operation.toString().toLowerCase())//
      .result(result) //
      .build();
  }
}
