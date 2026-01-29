package com.bootcamp.demo_mtr.service;

import com.bootcamp.demo_mtr.entity.LineEntity;
import com.bootcamp.demo_mtr.entity.StationEntity;

public interface MTRService {
  LineEntity saveLine(String lineCode, String lineDesc);

  StationEntity saveStation(String lineCode, String StationCode, String StationDesc, 
     String preCode, String nextCode);

  void deleteAllLines();
  void deleteAllStaitons();
}
