package com.bootcamp.demo.demo_weather.dto;

import java.time.LocalDate;
import lombok.Builder;
import lombok.Getter;

// ! Controller API return the following data format. (List<WeatherDto>, sort by forecastDate)

@Getter
@Builder
public class NineDayDto {
  private LocalDate forecastDate;
  private Double maxTemp;
  private Double minTemp;
  private Double maxRh;
  private Double minRh;
}