package com.bootcamp.demo.demo_weather.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.bootcamp.demo.demo_weather.model.DataType;
import com.bootcamp.demo.demo_weather.model.Lang;
import com.bootcamp.demo.demo_weather.model.dto.WeatherDTO;
import com.bootcamp.demo.demo_weather.service.NineDayService;
import com.bootcamp.demo.demo_weather.service.WeatherService;

@Service
public class WeatherServiceImpl implements WeatherService {
  @Autowired
  private NineDayService nineDayService;

  @Override
  public WeatherDTO getWeather(DataType dataType, Lang lang) {
    return switch (dataType) {
      case NINE_DAY -> this.nineDayService.getWeather(lang);
    };
  }
}