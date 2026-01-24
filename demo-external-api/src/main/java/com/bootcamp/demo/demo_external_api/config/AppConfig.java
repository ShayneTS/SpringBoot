package com.bootcamp.demo.demo_external_api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import com.bootcamp.demo.demo_external_api.mapper.DtoMapper;
import com.bootcamp.demo.demo_external_api.mapper.EntityMapper;
import com.bootcamp.demo.demo_external_api.model.Cat;

@Configuration
public class AppConfig {
  @Bean
  RestTemplate restTemplate() {
    return new RestTemplate();
  }

  @Bean(name = "superCat")
  Cat Cat1() {
    return new Cat("JQK", 10);
  }

  @Bean(name = "smallCat")
  Cat cat2() {
    return new Cat("ABC", 7);
  }

  @Bean
  DtoMapper dtoMapper(){
    return new DtoMapper();
  }

  @Bean
  EntityMapper entityMapper(){
    return new EntityMapper();
  }
}
