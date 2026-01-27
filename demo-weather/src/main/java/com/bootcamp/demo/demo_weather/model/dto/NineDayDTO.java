package com.bootcamp.demo.demo_weather.model.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class NineDayDTO extends WeatherDTO {
  private String generalSituation;
  @JsonProperty(value = "weatherForecast")
  private List<ForecastDTO> weatherForecasts;
  // TBC. (zone)
  @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Hong_Kong")
  private LocalDateTime updateTime;
  private ValueDTO2 seaTemp;
  @JsonProperty(value = "soilTemp")
  private List<ValueDTO2> soilTemps;

  @Getter
  public static class ValueDTO2 {
    private String place;
    private Double value;
    private String unit;
    // TBC. (zone)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Hong_Kong")
    private LocalDateTime recordTime;
    private DepthDTO depth;
  }

  @Getter
  public static class DepthDTO{
    private String unit;
    private Double value;
  }

  @Getter
  public static class ForecastDTO {
    @JsonFormat(pattern = "yyyyMMdd")
    private LocalDate forecastDate;
    private String week;
    @JsonProperty(value = "forecaseWind")
    private String wind;
    @JsonProperty(value = "forecaseWeather")
    private String description;
    private ValueDTO forecastMaxtemp;
    private ValueDTO forecastMintemp;
    private ValueDTO forecastMaxrh;
    private ValueDTO forecastMinrh;
    @JsonProperty(value = "forecastIcon")
    private Long ForecastIcon;
    @JsonProperty(value = "PSR")
    private String psr;

    @Getter
    public static class ValueDTO {
      private Double value;
      private String unit;
    }
    
  }
}
