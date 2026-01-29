package com.bootcamp.demo_mtr.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.bootcamp.demo_mtr.entity.StationEntity;

public interface MTROperation {
  @PostMapping(value = "/line/{lineCode}/station")
  StationEntity createStation(@PathVariable String lineCode, 
      @RequestBody stationEntity);
}
