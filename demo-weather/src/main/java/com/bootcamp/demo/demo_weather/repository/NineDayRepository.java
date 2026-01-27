package com.bootcamp.demo.demo_weather.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.bootcamp.demo.demo_weather.entity.NineDayEntity;
import java.time.LocalDate;
import java.time.LocalDateTime;



// ! JPA -> Hibernate (Agent generate class, which implement this interface)

@Repository
public interface NineDayRepository extends JpaRepository<NineDayEntity, Long>{
  // save -> insert into
  // saveall -> insert into
  // findById// existById -> select * from xxx where id = ?
  // deleteAll -> delete from xxx;
  // deleteById -> delete from xxx where id = ?

  // find by ForecastDate

  // ! 1. JPA method
  // ! Read the method name -> generate SQL (according to yml - MySQL)
  List<NineDayEntity> findByForecastDate(LocalDate forecastDate);

  // maxTemp >= 20
  List<NineDayEntity> findByMaxTempGreaterThanEqual(Double degree);

  // select * from nine_day_weathers where tran_time between xxx and yyy;
  List<NineDayEntity> findByTranTimeBetween(LocalDateTime startDateTime,
      LocalDateTime endDateTime);

  // ! 2. JPQL (Java Persistance Query Language)
  @Query(value = "select e from NineDayEntity e where e.forecastDate =:forecastDate")
  List<NineDayEntity> findByForecastDateJPQ(LocalDate forecastDate);

  @Query(value = "select e from NineDayEntity e where e.maxTemp >= :degree")
  List<NineDayEntity> findByMaxTempGreaterThanEqualJPQL(Double degree);

  // ! 3. Native Query (Product Specific SQL) (last resort only)
  @Query(
      value = "select n.id, n.tran_time, n.forecast_date, n.max_temp, n.min_temp, n.max_rh, n.min_rh from nine_day_weathers n where n.forecast_date = :forecastDate",
      nativeQuery = true)
  List<NineDayEntity> findByFOrecastDateNQ(LocalDate forecastDate);


}
