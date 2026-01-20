package com.bootcamp.demo.demo_basic_api.model;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@AllArgsConstructor
public class Student {
  @Setter
  private Long id;
  private String name;
  private String clazz; // to avoid using keyword class
  private LocalDate dob; // date of birth
}
