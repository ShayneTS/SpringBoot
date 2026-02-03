package com.bootcamp.demo_mtr.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.bootcamp.demo_mtr.dto.EarliestScheduleDto;
import com.bootcamp.demo_mtr.entity.StationEntity;
import com.bootcamp.demo_mtr.model.dto.ScheduleDTO;

public interface MTROperation {
  @PostMapping(value = "/line/{lineCode}/station")
  StationEntity createStation(@PathVariable String lineCode,
      @RequestBody StationEntity stationEntity);

  @GetMapping(value = "/mtr/schedule")
  ScheduleDTO getSchedule(@RequestParam String line, @RequestParam String sta);

  @GetMapping(value = "/mtr/schedulemap")
  EarliestScheduleDto getScheduleMap(@RequestParam String line, @RequestParam String sta);
}