package com.bootcamp.demo_mtr.mapper;

import org.springframework.stereotype.Component;
import com.bootcamp.demo_mtr.model.Train;
import com.bootcamp.demo_mtr.model.dto.ScheduleDTO;

@Component
public class ModelMapper {
  public Train map(String direction, ScheduleDTO.StationDTO.TrainDTO trainDTO) {
    return Train.builder() //
      .destination(trainDTO.getDest()) //
      .arrivalTime(trainDTO.getTime()) //
      .direction(direction) //
      .build();
  }
}
