package com.bootcamp.demo.demo_weather.mapper;

import java.math.BigDecimal;
import org.springframework.stereotype.Component;
import com.bootcamp.demo.demo_weather.entity.NineDayEntity;
import com.bootcamp.demo.demo_weather.model.dto.NineDayDTO;

@Component
public class EntityMapper {
  public NineDayEntity map(NineDayDTO.ForecastDTO dto){
    return NineDayEntity.builder() //
      .forecastDate(dto.getForecastDate()) //
      .maxTemp(BigDecimal.valueOf(dto.getForecastMaxtemp().getValue())) //
      .minTemp(BigDecimal.valueOf(dto.getForecastMintemp().getValue())) //
      .maxRh(BigDecimal.valueOf(dto.getForecastMaxrh().getValue())) //
      .minRh(BigDecimal.valueOf(dto.getForecastMinrh().getValue()))//
      .build();
  }
}
