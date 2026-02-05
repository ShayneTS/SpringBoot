package com.bootcamp.demo_mtr.service.impl;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.bootcamp.demo_mtr.codelib.RedisManager;
import com.bootcamp.demo_mtr.entity.LineEntity;
import com.bootcamp.demo_mtr.entity.StationEntity;
import com.bootcamp.demo_mtr.mapper.ModelMapper;
import com.bootcamp.demo_mtr.model.Train;
import com.bootcamp.demo_mtr.model.dto.ScheduleDTO;
import com.bootcamp.demo_mtr.repository.LineRepository;
import com.bootcamp.demo_mtr.repository.StationRepository;
import com.bootcamp.demo_mtr.service.MTRService;
import tools.jackson.databind.ObjectMapper;

@Service
public class MTRServiceImpl implements MTRService {
  @Autowired
  private LineRepository lineRepository;
  @Autowired
  private StationRepository stationRepository;

  @Value(value = "${external-api.mtr.domain}")
  private String domain;

  @Value(value = "${external-api.mtr.path-segment}")
  private String pathSegment;

  @Value(value = "${external-api.mtr.path}")
  private String path;

  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private ModelMapper modelMapper;

  @Autowired
  // private RedisTemplate<String, String> redisTemplate;
  private RedisManager redisManager;

  @Override
  public LineEntity saveLine(String lineCode, String lineDesc) {
    LineEntity lineEntity = LineEntity.builder() //
        .code(lineCode) //
        .description(lineDesc) //
        .build();
    return this.lineRepository.save(lineEntity);
  }

  @Override
  public StationEntity saveStation(String lineCode, String stationCode,
      String stationDesc, String prevCode, String nextCode) {
    // findByCode -> LineEntity
    LineEntity lineEntity = this.lineRepository.findByCode(lineCode) //
        .orElseThrow(() -> new IllegalArgumentException("Line Not Found."));
    // Prepare StationEntity -> set FK
    StationEntity stationEntity = StationEntity.builder() //
        .code(stationCode) //
        .description(stationDesc) //
        .lineEntity(lineEntity) //
        .prevCode(prevCode) //
        .nextCode(nextCode) //
        .build();
    // save
    return this.stationRepository.save(stationEntity);
  }

  @Override
  public ScheduleDTO getSchedule(String lineCode, String stationCode) {
    String url = UriComponentsBuilder.newInstance() //
        .scheme("https") //
        .host(domain) //
        .pathSegment(pathSegment) //
        .path(path) //
        .queryParam("line", lineCode) //
        .queryParam("sta", stationCode) //
        .build() //
        .toUriString();
    System.out.println("url=" + url);
    return this.restTemplate.getForObject(url, ScheduleDTO.class);
  }

  @Override
  public Map<String, List<Train>> getScheduleMap(String lineCode,
      String stationCode) {
    ScheduleDTO scheduleDTO = this.getSchedule(lineCode, stationCode);

    Map<String, List<Train>> stationMap = new HashMap<>();

    String key = lineCode + "-" + stationCode;
    List<ScheduleDTO.StationDTO.TrainDTO> upTrains =
        scheduleDTO.getData().get(key).getUpTrains();
    for (ScheduleDTO.StationDTO.TrainDTO trainDTO : upTrains) {
      Train train = this.modelMapper.map("UP", trainDTO);
      List<Train> trains =
          stationMap.getOrDefault(trainDTO.getDest(), new ArrayList<>());
      trains.add(train);
      stationMap.put(trainDTO.getDest(), trains);
    }
    List<ScheduleDTO.StationDTO.TrainDTO> downTrains =
        scheduleDTO.getData().get(key).getDownTrains();
    for (ScheduleDTO.StationDTO.TrainDTO trainDTO : downTrains) {
      Train train = this.modelMapper.map("DOWN", trainDTO);
      List<Train> trains =
          stationMap.getOrDefault(trainDTO.getDest(), new ArrayList<>());
      trains.add(train);
      stationMap.put(trainDTO.getDest(), trains);
    }
    return stationMap;
  }

  @Override
  public void deleteAllLines() {
    this.lineRepository.deleteAll();
  }

  @Override
  public void deleteAllStations() {
    this.stationRepository.deleteAll();
  }

  // ! Read Database
  @Override
  public List<StationEntity> getStations(String lineCode) {
    // ! Step 1: read redis
    StationEntity[] stationEntities = this.redisManager.get(lineCode, StationEntity[].class);
    // ! Step 2a: if redis found, return List<StationEntity>
    if (stationEntities != null) {
      return Arrays.asList(stationEntities);
    } else {
      // ! Step 2b: if redis not found, read Database -> write back redis -> return return
      // List<StationEntity>
      LineEntity lineEntity =
          this.lineRepository.findByCode(lineCode).orElseThrow(
              () -> new IllegalArgumentException("Line Code Not Found."));
      List<StationEntity> stationEntitiesFromDB =
          this.stationRepository.findByLineEntity(lineEntity);

      // Serialization (Java Object -> String)
      this.redisManager.set(lineCode, stationEntitiesFromDB, 
          Duration.ofSeconds(30));
      return stationEntitiesFromDB;
    }
  }
}