package com.bootcamp.demo_mtr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bootcamp.demo_mtr.entity.StationEntity;

@Repository
public interface StationRepository extends JpaRepository<StationEntity, Long>{
  
}