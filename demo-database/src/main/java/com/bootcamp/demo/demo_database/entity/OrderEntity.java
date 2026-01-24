package com.bootcamp.demo.demo_database.entity;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class OrderEntity {
  @Id // ! PK
  @GeneratedValue(strategy = GenerationType.IDENTITY) // ! auto_increment
  private Long id;
  @Column(name = "order_datetime")
  private LocalDateTime orderDateTime;
  @Column(name = "order_amount")
  private Double amount;

  // ! FK
  @Setter
  @ManyToOne
  @JoinColumn(name = "customer_id", nullable = false)
  private CustomerEntity customerEntity;
}
