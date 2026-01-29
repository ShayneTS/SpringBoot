package com.bootcamp.demo_mtr.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bootcamp.demo_mtr.entity.LineEntity;
import java.util.List;


@Repository
public interface LineRepository extends JpaRepository<LineEntity, Long>{

  // ! JPA method -> return type
  // 1. Optional<xxx>
  // 2. List<xxx>
  Optional<LineEntity> findByCode(String code);
}
