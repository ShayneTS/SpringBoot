package com.calculator.demo_bc_calculator.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import org.springframework.stereotype.Service;
import com.calculator.demo_bc_calculator.model.Operation;

@Service
public class CalculatorService {
  
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
