package com.bootcamp.demo.demo_basic_api.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bootcamp.demo.demo_basic_api.model.Database;
import com.bootcamp.demo.demo_basic_api.model.Student;

@Controller
@ResponseBody
@RequestMapping(value = "/student")
public class StudentController {
  // PostMapping
  @PostMapping
  public Student create(@RequestBody Student student) {
    return Database.students.add(student) ? student : null;
  }

  // GetMapping
  @GetMapping(value = "/all")
  public List<Student> getAllStudents() {
    return Database.students;
  }
}