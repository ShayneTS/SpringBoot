package com.bootcamp.demo_mtr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.web.client.RestTemplate;
import com.bootcamp.demo_mtr.codelib.RedisManager;
import tools.jackson.databind.ObjectMapper;

// Bean RestTemplate

@Configuration
public class AppConfig {
  @Bean
  RestTemplate restTemplate() {
    return new RestTemplate();
  }

  @Bean
  ObjectMapper objectMapper() {
    return new ObjectMapper();
  }

  @Bean
  RedisManager redisManager(RedisConnectionFactory factory, ObjectMapper objectMapper) {
    return new RedisManager(factory, objectMapper);
  }
}
