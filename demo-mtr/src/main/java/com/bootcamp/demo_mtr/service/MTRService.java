package com.bootcamp.demo_mtr.service;

import java.util.List;
import java.util.Map;
import com.bootcamp.demo_mtr.entity.LineEntity;
import com.bootcamp.demo_mtr.entity.StationEntity;
import com.bootcamp.demo_mtr.model.dto.ScheduleDTO;

public interface MTRService {
  LineEntity saveLine(String lineCode, String lineDesc);

  StationEntity saveStation(String lineCode, String stationCode, String stationDesc, 
     String preCode, String nextCode);

  
  void deleteAllLines();

  void deleteAllStaitons();

  ScheduleDTO getSchedule(String lineCode, String stationCode);

  // "TKO", Train Object
  Map<String, List<Train>> getScheduleMap(String lineCode, String stationCode);
}
