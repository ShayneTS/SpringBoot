package com.bootcamp.demo.demo_weather.service;

import com.bootcamp.demo.demo_weather.model.Lang;
import com.bootcamp.demo.demo_weather.model.dto.NineDayDTO;

public interface NineDayService {
  NineDayDTO getWeather(Lang lang);
}
