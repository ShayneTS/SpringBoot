package com.bootcamp.demo.demo_weather.model;

import java.util.Arrays;
import lombok.Getter;

@Getter
public enum Lang {
  EN("en"), //
  TC("tc"), //
  ;
  private String value;

  private Lang(String value){
    this.value = value;

  }

  // "en" -> EN
  public static Lang of(String lang) {
    return Arrays.asList(Lang.values()).stream() //
      .filter(e -> lang.equals(e.getValue())) //
      .findAny()//
      .orElseThrow(() -> new IllegalArgumentException("Invalid Language"));
  }
}
