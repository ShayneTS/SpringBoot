package com.bootcamp.demo_mtr.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bootcamp.demo_mtr.entity.LineEntity;
import com.bootcamp.demo_mtr.entity.StationEntity;
import com.bootcamp.demo_mtr.repository.LineRepository;
import com.bootcamp.demo_mtr.repository.StationRepository;
import com.bootcamp.demo_mtr.service.MTRService;

@Service
public class MTRServiceImpl implements MTRService{
  @Autowired
  private LineRepository lineRepository;
  @Autowired
  private StationRepository stationRepository;

  @Override
  public LineEntity saveLine(String lineCode, String lineDesc){
    LineEntity lineEntity = LineEntity.builder()//
        .code(lineCode)//
        .description(lineDesc)//
        .build();
      return this.lineRepository.save(lineEntity);
  }

  @Override
  public StationEntity saveStation(String lineCode, String StationCode,
    String StationDesc, String preCode, String nextCode) {
      // findByCode -> LineEntity
      LineEntity lineEntity = this.lineRepository.findByCode(lineCode) //
        .orElseThrow(() -> new IllegalArgumentException("Line Not Found."));
      // Prepare StationEntity -> set FK
      StationEntity stationEntity = StationEntity.builder() //
      .code(StationCode) //
      .description(StationDesc) //
      .lineEntity(lineEntity)//
      .prevCode(StationDesc)//
      .nextCode(StationDesc)//
      .build();
      // save
      return this.stationRepository.save(stationEntity);
    }


  @Override
  public void deleteAllLines(){
    this.lineRepository.deleteAll();
  }

  @Override
  public void deleteAllStaitons(){
    this.stationRepository.deleteAll(); 
  }
}
