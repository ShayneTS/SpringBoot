package com.bootcamp.demo_mtr.model.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class ScheduleDTO {

  @JsonProperty(value = "sys_time")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime systTime;

  @JsonProperty(value = "curr_time")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime currtTime;

  Map<String, StationDTO> data;


  private String isdelay;
  private Integer status;
  private String message;

  @Getter
  public static class TrainDTO{
    private String seq;
    private String dest;
    private String plat;
    @JsonFormat();
    private LocalDateTime time;
    private String ttnt;
    private String valid;
    private String source;
  }

  @Getter
  public static class StationDTO{  
  @JsonProperty(value = "sys_time")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime systTime;

  @JsonProperty(value = "curr_time")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime currtTime;

  @JsonProperty(value = "UP")
  private List<TrainDTO> upTrains;
  @JsonProperty(value = "DOWN")
  private List<TrainDTO> downTrains;
}


}
