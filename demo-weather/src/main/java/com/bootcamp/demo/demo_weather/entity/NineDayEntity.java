package com.bootcamp.demo.demo_weather.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// ! insert 9 days data into database per API Call
// ! means record all history for the call

// https://data.weather.gov.hk/weatherAPI/opendata/weather.php?dataType=fnd&lang=en

@Entity
@Table(name = "nine_day_weathers")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder //Mapper
public class NineDayEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) // then write this
  private Long id; // write this first
  @Setter
  private LocalDateTime tranTime;
  // API Result
  @Column(name = "forecast_date")
  private LocalDate forecastDate;
  @Column(name = "max_temp", precision = 5, scale = 2) // decimal(5,2)
  private BigDecimal maxTemp;
    @Column(name = "min_temp", precision = 5, scale = 2) // decimal(5,2)
  private BigDecimal minTemp;
  @Column(name = "max_rh", precision = 5, scale = 2) // decimal(5,2)
  private BigDecimal maxRh;
  @Column(name = "min_rh", precision = 5, scale = 2) // decimal(5,2)
  private BigDecimal minRh;
}
