package com.bootcamp.demo.demo_external_api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "jph_users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class UserEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String username;
  private String name;
  private String email;
  private String street;
  private String suite;
  private String city;
  private String zipcode;
  private String phone;
  private String website;
  @Column(name = "company_name")
  private String companyName;
  @Column(name = "company_catch_phrase")
  private String companyCatchPhrase;
  @Column(name = "company_bs")
  private String companyBs;
  private String latitude;
  private String longitude;

}
