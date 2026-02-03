package com.bootcamp.demo_mtr.model;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
public class Train {
  private String destination;
  private LocalDateTime arrivalTime;
  private String direction;
}
