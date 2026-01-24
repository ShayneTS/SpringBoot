package com.bootcamp.demo.demo_external_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bootcamp.demo.demo_external_api.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{ // the Long is the type of the PK

  
}
