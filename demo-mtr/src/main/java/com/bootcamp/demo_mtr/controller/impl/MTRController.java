package com.bootcamp.demo_mtr.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo_mtr.controller.MTROperation;
import com.bootcamp.demo_mtr.entity.StationEntity;
import com.bootcamp.demo_mtr.service.MTRService;

@RestController
public class MTRController implements MTROperation{
  @Autowired
  private MTRService mtrService;

  @Override
  public StationEntity createStation(String lineCode,
      StationEntity stationEntity){
    return this.mtrService.saveStation(lineCode, stationEntity.getCode(), 
        stationEntity.getDescription(), 
        stationEntity.getPrevCode(), 
        stationEntity.getNextCode());
      }
}
