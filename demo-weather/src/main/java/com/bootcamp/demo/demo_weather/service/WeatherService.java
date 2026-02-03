package com.bootcamp.demo.demo_weather.service;

import com.bootcamp.demo.demo_weather.model.DataType;
import com.bootcamp.demo.demo_weather.model.Lang;
import com.bootcamp.demo.demo_weather.model.dto.WeatherDTO;

// dataType, language

public interface WeatherService {
  WeatherDTO getWeather(DataType dataType, Lang lang);
}