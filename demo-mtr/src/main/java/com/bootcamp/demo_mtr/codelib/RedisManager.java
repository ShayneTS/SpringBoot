package com.bootcamp.demo_mtr.codelib;

import java.time.Duration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import tools.jackson.databind.ObjectMapper;

// Cat name age

// new RedisManager
public class RedisManager {
  private RedisTemplate<String, String> redisTemplate;
  private ObjectMapper objectMapper;

  public RedisManager(RedisConnectionFactory factory, ObjectMapper objectMapper) {
     RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
    redisTemplate.setConnectionFactory(factory);
    redisTemplate.setKeySerializer(RedisSerializer.string());
    redisTemplate.setValueSerializer(RedisSerializer.json());
    redisTemplate.afterPropertiesSet();
    this.redisTemplate = redisTemplate;
    this.objectMapper = objectMapper;
  }

  public <T> T get(String key, Class<T> clazz) {
    String json = this.redisTemplate.opsForValue().get(key);
    if (json == null)
      return null;
    return this.objectMapper.readValue(json, clazz);
  }

  public <T> void set(String key, T value, Duration duration) {
    String json = this.objectMapper.writeValueAsString(value);
    this.redisTemplate.opsForValue().set(key, json, duration);
  }
}