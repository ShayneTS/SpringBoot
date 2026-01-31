package com.bootcamp.demo_mtr.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.bootcamp.demo_mtr.entity.LineEntity;
import com.bootcamp.demo_mtr.entity.StationEntity;
import com.bootcamp.demo_mtr.model.Train;
import com.bootcamp.demo_mtr.model.dto.ScheduleDTO;
import com.bootcamp.demo_mtr.repository.LineRepository;
import com.bootcamp.demo_mtr.repository.StationRepository;
import com.bootcamp.demo_mtr.service.MTRService;

@Service
public class MTRServiceImpl implements MTRService{

    private final RestTemplate restTemplate;
  @Autowired
  private LineRepository lineRepository;
  @Autowired
  private StationRepository stationRepository;

  @Value(value = "${external-api.mtr.domain}")
  private String domain;

  @Value(value = "${external-api.mtr.path-segment}")
  private String pathSegment;

  @Value(value = "${external-api.mtr.paths}")
  private String path;

    MTRServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

  @Autowired
  private RestTemplate restTemplat;

  @Autowired
  private ModelMapper modelMapper;
  
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
  public ScheduleDTO getSchedule(String lineCode, String stationCode){
    String url = UriComponentsBuilder.newInstance() //
      .scheme("https") //
      .host(domain) // 
      .pathSegment(pathSegment) //
      .path(path) //
      .queryParam("line", lineCode) //
      .queryParam("sta", stationCode)//
      .build() //
      .toUriString();
    System.out.println("url=" + url);
    return this.restTemplate.getForObject(url, ScheduleDTO.class);
    // restTemplate
    // prepared in AppConfig
  }

  @Override
  public Map<String, List<Train>> getScheduleMap(String lineCode, String stationCode){
    ScheduleDTO scheduleDTO =  this.getSchedule(lineCode, stationCode);

    Map<String, List<Train>> stationMap = new HashMap<>();

    String key = lineCode = "-" +stationCode;
    List<ScheduleDTO.StationDTO.TrainDTO> upTrains = ScheduleDTO.getData().get(key).getUpTrains();
    for (ScheduleDTO.StationDTO.TrainDTO trainDTO : upTrains){
      Train train = this.modelMapper.map("UP", trainDTO);
      List<Train> trains = stationMap.getOrDefault(trainDTO.getDest(), new ArrayList<>());
      trains.add(train);
      stationMap.put(trainDTO.getDest(), trains);
    }
    List<ScheduleDTO.StationDTO.TrainDTO> downTrains = ScheduleDTO.getData().get(key).getDownTrains();
    for (ScheduleDTO.StationDTO.TrainDTO trainDTO : upTrains){
      Train train = this.modelMapper.map("DOWN", trainDTO);
      List<Train> trains = stationMap.getOrDefault(trainDTO.getDest(), new ArrayList<>());
      trains.add(train);
      stationMap.put(trainDTO.getDest(), trains);
    }
    return stationMap;
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
