package com.bootcamp.demo.demo_weather.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.bootcamp.demo.demo_weather.entity.NineDayEntity;
import com.bootcamp.demo.demo_weather.model.Lang;
import com.bootcamp.demo.demo_weather.model.dto.NineDayDTO;
import com.bootcamp.demo.demo_weather.repository.NineDayRepository;
import com.bootcamp.demo.demo_weather.service.NineDayService;

@Service
public class NineDayServiceImpl implements NineDayService {

    private final NineDayRepository nineDayRepository;
    @Autowired
    private RestTemplate restTemplate;
    
    @Value("${api.data-weather.domain}")
    private String domain;
    @Value("${api.data-weather.path-segment}")
    private String pathSegment;
    @Value("${api.data-weather.path}")
    private String path;


    NineDayServiceImpl(NineDayRepository nineDayRepository) {
        this.nineDayRepository = nineDayRepository;
    }


    @Autowired
    //;lkjasfd
    @Override
    public NineDayDTO getWeather(Lang lang){
      String url = UriComponentsBuilder.newInstance() //
        .scheme("https")//
        .host(domain)//
        .pathSegment(pathSegment) //
        .path(path) //
        .queryParam("dataType", datatype) // 
        .queryParam("lang", lang.getValue()) //
        .build()//
        .toUriString();
      System.out.println("url=" + url);
      // ! something here about nineDayDTO
      return this.restTemplate.getForObject(url, NineDayDTO.class);


      // stream
      LocalDateTime now = LocalDateTime.now();
      List<NineDayEntity> nineDayEntities = 
        nineDayDTO.getWeatherForecasts().stream()//
         .map(e -> {
            NineDayEntity entity = this.entityMapper.map(e);
            entity.setTranTime(now);
            return entity;
          }).collect(Collectors.toList());

      this.nineDayRepository.saveAll(nineDayEntities); //

      return nineDayDTO;

    }   
  }

