package com.bootcamp.demo.demo_basic_api.model;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Student {
  private String name;
  private int sid;
  private String clazz; // to avoid using keyword class
  private LocalDate dob; // date of birth
}
