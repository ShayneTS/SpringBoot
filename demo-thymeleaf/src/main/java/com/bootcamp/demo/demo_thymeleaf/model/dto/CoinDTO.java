package com.bootcamp.demo.demo_thymeleaf.model.dto;

import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class CoinDTO {
  private String id;
  private String symbol;
  private String name;
  private String image;
  @JsonProperty(value = "current_price")
  private String currentPrice;
  @JsonProperty(value = "market_cap")
  private String marketCap;
  @JsonProperty(value = "market_cap_rank")
  private Long marketCapRank;
  @JsonProperty(value = "fully_diluted_valuation")
  private Long fullyDilutedValudation;
  @JsonProperty(value = "total_volume")
  private Double totalVolume;
  @JsonProperty(value = "high_24h")
  private Double high24h;
  @JsonProperty(value = "low_24h")
  private Double low24h;
  @JsonProperty(value = "price_change_24h")
  private Double priceChange24h;
  @JsonProperty(value = "price_change_percentage_24h")
  private Double priceChangePercentage24h;
  @JsonProperty(value = "market_cap_change_24h")
  private Double marketCapChange24h;
  @JsonProperty(value = "market_cap_change_percentage_24h")
  private Double marketCapChangePercentage24h;
  @JsonProperty(value = "circulating_supply")
  private Double circulatingSupply;
  @JsonProperty(value = "total_supply")
  private Double totalSupply;
  @JsonProperty(value = "max_supply")
  private Double maxSupply;
  private Double ath;
  @JsonProperty(value = "ath_change_percentage")
  private Double athChangePercentage;
  @JsonProperty(value = "ath_date")
  private LocalDateTime athDate;
  private Double atl;
  @JsonProperty(value = "atl_change_percentage")
  private Double atlChangePercentage;
  @JsonProperty(value = "atl_date")
  private LocalDateTime atlDate;
  private ROI roi;
  @JsonProperty(value = "last_updated")
  private LocalDateTime lastUpdated;

  @Getter
  private static class ROI {
    private Double times;
    private String currency;
    private Double percentage;
  }
}