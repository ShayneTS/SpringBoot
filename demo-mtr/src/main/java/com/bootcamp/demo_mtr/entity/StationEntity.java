package com.bootcamp.demo_mtr.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "mtr_stations")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class StationEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String code;
  private String description;
  private String prevCode;
  private String nextCode;

  @ManyToOne
  @JoinColumn(name = "line_id")
  private LineEntity lineEntity;
}
