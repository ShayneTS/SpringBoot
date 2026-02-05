package com.bootcamp.demo.demo_thymeleaf.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CoinDTO {
  // ! put sir's answer here
  //...

  @JsonProperty(value = "price_change_24h")
  private Double price_change_24h;
  @JsonProperty(value = "price_change_percentage_24h")
  private Double price_change_percentage_24h;
  @JsonProperty(value = "market_cap_change_24h")
  private Double market_cap_change_24h;
  @JsonProperty(value = "circulating_supply")
  private Double circulating_supply;

  //...
}
