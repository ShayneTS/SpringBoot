package com.calculator.demo_bc_calculator.model;

public class Superman {
  
  // ! Correct Design
  public static double bmi(double height, double weight) {
    return height / weight;
  }

  // ! Waste of Object
  public double bmi2(double height, double weight) {
    return height / weight;
  }

  public static void main(String[] args) {
    // ! In Java World (No Spring), using Superman Object to calculate 3.5 / 5.5 is wasting memory.
    new Superman().bmi2(3.5, 5.5);
    Superman.bmi(3.5, 5.5);

    // ! In Spring, Bean (Single Object in Memory - Spring Context)
    // @Autowired Superman superman;
    // this.superman.bmi2(3.5, 5.5);
  }
}