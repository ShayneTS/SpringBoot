package com.bootcamp.demo.demo_weather.model;

import java.util.Arrays;
import lombok.Getter;

@Getter
public enum DataType {
  NINE_DAY("fnd"), //
  ;

  private String value;

  private DataType(String value){
    this.value = value;
  }
  public static Lang of(String lang) {
    return Arrays.asList(Lang.values()).stream() //
      .filter(e -> lang.equals(e.getValue())) //
      .findAny()//
      .orElseThrow(() -> new IllegalArgumentException("Invalid Language"));
  }


}
