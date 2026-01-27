package com.bootcamp.demo.demo_weather.dto;

import java.time.LocalDate;
import lombok.Getter;

// ! Controller API return the following data format. (List<WeatherDto>, sort by forecastDate)

@Getter
public class WeatherDto {
  private LocalDate forecastDate;
  private Double forecastMaxtemp;
  private Double forecastMintemp;
  private Double forecastMaxRh;
  private Double forecastMinRh;
  // forecastDate
  // maxTemp
  // minTemp
  // maxRh
  // minRh
  public static Object builder() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'builder'");
  }
}
