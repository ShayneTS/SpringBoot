package com.bootcamp.demo_mtr.dto;

import java.time.LocalDateTime;
import java.util.List;
import com.bootcamp.demo_mtr.model.Train;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class EarliestScheduleDto {
  @JsonProperty(value = "sys_time")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime sysTime;

  @JsonProperty(value = "curr_time")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime currTime;

  private String currentStation;
  private List<Train> trains;
}
