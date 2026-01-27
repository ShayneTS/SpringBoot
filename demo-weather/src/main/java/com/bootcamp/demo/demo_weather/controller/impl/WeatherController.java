package com.bootcamp.demo.demo_weather.controller.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.demo_weather.controller.WeatherOperation;
import com.bootcamp.demo.demo_weather.dto.WeatherDto;
import com.bootcamp.demo.demo_weather.mapper.DtoMapper;
import com.bootcamp.demo.demo_weather.model.DataType;
import com.bootcamp.demo.demo_weather.model.Lang;
import com.bootcamp.demo.demo_weather.model.dto.NineDayDTO;
import com.bootcamp.demo.demo_weather.model.dto.WeatherDTO;
import com.bootcamp.demo.demo_weather.service.WeatherService;

@RestController
public class WeatherController implements WeatherOperation{

    private final DtoMapper dtoMapper;

    WeatherController(DtoMapper dtoMapper) {
        this.dtoMapper = dtoMapper;
    }
  @Autowired

  // ! return List<NinDayDto>
  @Override
  public List<WeatherDto> getWeather(String dataType,  String lang){
    WeatherDTO weatherDTO = 
        WeatherService.getWeather(DataType.of(dataType), Lang.of(lang));

    NineDayDTO nineDayDTO = null;
    if (weatherDTO instanceof NineDayDTO) {
      nineDayDTO = (NineDayDTO) weatherDTO;
    }
    return NineDayDTO.getWeatherForecasts().stream()//
      .map(e -> this.dtoMapper.map(e))//
      .collect(Collectors.toList())
  }
}
