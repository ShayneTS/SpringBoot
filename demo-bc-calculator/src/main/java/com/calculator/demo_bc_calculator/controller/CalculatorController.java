package com.calculator.demo_bc_calculator.controller;

import java.math.BigDecimal;
import java.math.RoundingMode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.calculator.demo_bc_calculator.dto.DTOMapper;
import com.calculator.demo_bc_calculator.model.ApiRequest;
import com.calculator.demo_bc_calculator.model.ApiResponse;
import com.calculator.demo_bc_calculator.model.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

// Step 1: GET /operation
// Step 2: CalculatorController Object -> call instance method calculate1(xxx)

@RestController // ! @Controller + @ResponseBody
public class CalculatorController {
  // ! GET http://localhost:8080/operation?x=3.0&y=11.5&operation=MUL
  @GetMapping(value = "/operation")
  public ApiResponse calculate1(@RequestParam String x, @RequestParam String y,
      @RequestParam Operation operation) {
    double result = -1.0;
    try {
      result = calculate(Double.valueOf(x), Double.valueOf(y), operation);
    } catch (NumberFormatException e) {
      // TBC
    }
    return DTOMapper.map(x, y, operation, String.valueOf(result));
  }

  // ! POST http://localhost:8080/operation
  // ! {"x":"3.0","y":"2.5","operation":"ADD"}
  @PostMapping(value = "/operation")
  public ApiResponse calculate2(@RequestBody ApiRequest request) {
    double result = -1.0;
    try {
      result = calculate(Double.valueOf(request.getX()),
          Double.valueOf(request.getY()), request.getOperation());
    } catch (NumberFormatException e) {
      // TBC
    }
    return DTOMapper.map(request.getX(), request.getY(), request.getOperation(),
        String.valueOf(result));
  }

  @GetMapping(value = "/operation/{x}/{y}/{operation}")
  public ApiResponse calculate3(@PathVariable String x, @PathVariable String y,
      @PathVariable Operation operation) {
    double result = -1.0;
    try {
      result = calculate(Double.valueOf(x), Double.valueOf(y), operation);
    } catch (NumberFormatException e) {
      // TBC
    }
    return ApiResponse.builder() //
        .x(x) //
        .y(y) //
        .operation(operation.toString()) //
        .result(String.valueOf(result)) //
        .build();
  }

  public static double calculate(double d1, double d2, Operation operation) {
    return switch (operation) {
      case ADD -> BigDecimal.valueOf(d1).add(BigDecimal.valueOf(d2))
          .doubleValue();
      case SUB -> BigDecimal.valueOf(d1).subtract(BigDecimal.valueOf(d2))
          .doubleValue();
      case MUL -> BigDecimal.valueOf(d1).multiply(BigDecimal.valueOf(d2)) //
          .setScale(5).doubleValue();
      case DIV -> BigDecimal.valueOf(d1)
          .divide(BigDecimal.valueOf(d2), 5, RoundingMode.HALF_UP)
          .doubleValue();
    };
  }
}