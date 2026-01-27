package com.bootcamp.demo.demo_weather.mapper;

import org.springframework.stereotype.Component;
import com.bootcamp.demo.demo_weather.dto.WeatherDto;
import com.bootcamp.demo.demo_weather.model.dto.NineDayDTO;

@Component
public class DtoMapper {
  public WeatherDto map(NineDayDTO.ForecastDTO forecastDTO){
    return WeatherDto.builder() //
      .forecastDate(forecastDTO.getForecastDate())//
      .maxTemp(forecastDTO.getForecastMaxtemp())//
      .minTemp(forecastDTO.getForecastMintemp())//
      .maxRh(forecastDTO.getForecastMaxrh())//
      .minRh(forecastDTO.getForecastMinrh())//
      .build();
  }
}
