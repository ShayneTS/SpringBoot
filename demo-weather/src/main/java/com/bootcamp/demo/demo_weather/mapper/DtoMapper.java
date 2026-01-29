package com.bootcamp.demo.demo_weather.mapper;

import org.springframework.stereotype.Component;
import com.bootcamp.demo.demo_weather.dto.NineDayDto;
import com.bootcamp.demo.demo_weather.model.dto.NineDayDTO;

@Component
public class DtoMapper {
  public NineDayDto map(NineDayDTO.ForecastDTO forecastDTO) {
    return NineDayDto.builder() //
        .forecastDate(forecastDTO.getForecastDate()) //
        .maxTemp(forecastDTO.getForecastMaxtemp().getValue()) //
        .minTemp(forecastDTO.getForecastMintemp().getValue()) //
        .maxRh(forecastDTO.getForecastMaxrh().getValue()) //
        .minRh(forecastDTO.getForecastMinrh().getValue()) //
        .build();
  }
}