package com.bootcamp.demo_mtr.controller.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo_mtr.controller.MTROperation;
import com.bootcamp.demo_mtr.dto.EarliestScheduleDto;
import com.bootcamp.demo_mtr.entity.StationEntity;
import com.bootcamp.demo_mtr.model.Train;
import com.bootcamp.demo_mtr.model.dto.ScheduleDTO;
import com.bootcamp.demo_mtr.service.MTRService;

@RestController
public class MTRController implements MTROperation {
  @Autowired
  private MTRService mtrService;

  @Override
  public StationEntity createStation(String lineCode,
      StationEntity stationEntity) {
    return this.mtrService.saveStation(lineCode, stationEntity.getCode(),
        stationEntity.getDescription(), stationEntity.getPrevCode(),
        stationEntity.getNextCode());
  }

  @Override
  public ScheduleDTO getSchedule(String line, String sta) {
    return this.mtrService.getSchedule(line, sta);
  }

  // !
  @Override
  public EarliestScheduleDto getScheduleMap(String line, String sta) {
    
    Map<String, List<Train>> stationMap = this.mtrService.getScheduleMap(line, sta);
    ScheduleDTO scheduleDTO = this.mtrService.getSchedule(line, sta);

    EarliestScheduleDto earliestScheduleDto = EarliestScheduleDto.builder() //
      .currTime(scheduleDTO.getCurrTime()) //
      .sysTime(scheduleDTO.getSysTime()) //
      .currentStation(sta) //
      .trains(new ArrayList<>()) //
      .build();

    for (List<Train> trains : stationMap.values()) {
      Optional<Train> earliest = trains.stream() //
        .min((t1, t2) -> t1.getArrivalTime().isBefore(t2.getArrivalTime()) ? -1 : 1);
      earliest.ifPresent(train -> {
        earliestScheduleDto.getTrains().add(train);
      });
    }
    return earliestScheduleDto;
  }
}