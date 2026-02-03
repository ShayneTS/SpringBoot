package com.bootcamp.demo.demo_weather.controller.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.demo_weather.controller.WeatherOperation;
import com.bootcamp.demo.demo_weather.dto.NineDayDto;
import com.bootcamp.demo.demo_weather.mapper.DtoMapper;
import com.bootcamp.demo.demo_weather.model.DataType;
import com.bootcamp.demo.demo_weather.model.Lang;
import com.bootcamp.demo.demo_weather.model.dto.NineDayDTO;
import com.bootcamp.demo.demo_weather.model.dto.WeatherDTO;
import com.bootcamp.demo.demo_weather.service.WeatherService;

@RestController
public class WeatherController implements WeatherOperation {
  @Autowired
  private WeatherService weatherService;

  @Autowired
  private DtoMapper dtoMapper;

  /**
   * return List<NineDayDto>
   */
  @Override
  public List<NineDayDto> getWeather(String dataType, String lang) {
    WeatherDTO weatherDTO =
        weatherService.getWeather(DataType.of(dataType), Lang.of(lang));

    NineDayDTO nineDayDTO = null;
    if (weatherDTO instanceof NineDayDTO) {
      nineDayDTO = (NineDayDTO) weatherDTO;
    }
    return nineDayDTO.getWeatherForecasts().stream() //
        .map(e -> this.dtoMapper.map(e)) //
        .collect(Collectors.toList());
  }
}