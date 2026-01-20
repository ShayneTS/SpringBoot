package com.bootcamp.demo.demo_database.entity;

import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Entity: Use Java Code to write SQL (create table statement)
@Entity
@Table(name = "customers")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CustomerEntity {
  @Id // ! PK (Primary Key)
  @GeneratedValue(strategy = GenerationType.IDENTITY) // ! auto_increment
  private Long id;
  @Setter
  @Column(name = "c_name", length = 50)
  private String names;
  @Setter
  @Column(name = "c_dob")
  private LocalDate dob;
}
