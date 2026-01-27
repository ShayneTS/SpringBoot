package com.bootcamp.demo.demo_weather.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.bootcamp.demo.demo_weather.model.DataType;
import com.bootcamp.demo.demo_weather.model.Lang;
import com.bootcamp.demo.demo_weather.model.dto.WeatherDTO;

@Service
public class WeatherServiceImpl implements WeatherSerivce {
    private final RestTemplate restTemplate;
    WeatherServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
  @Override
  public WeatherDTO getWeather(DataType dataType, Lang lang){
    return switch (dataType) {
      case NINE_DAY -> this.nineDayService.getWeather(lang);
    }
  }
}
