package com.bootcamp.demo.demo_basic_api.controller;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bootcamp.demo.demo_basic_api.model.Database;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


// ! RESTful API
// Resource


@Controller
@ResponseBody
public class StringController {
  //input 2 strings, return concat their first characters
  // e.g. input hello world -> hw
  @GetMapping(value = "/string/{firstword}/{secondword}")
  public String concatFirstChar(@PathVariable (value = "firstword") String x, 
  @PathVariable (value = "secondword") String y){
    return "" + x.charAt(0) + y.charAt(0); // hw
    // if char + char -> int + int -> int // "223"

  }
  
  // ! API definitoin: XXXXMapping + URI path
  @PostMapping(value = "/database/{name}")
  
  //@GetMapping(value = "/database/add/{name}")
  public String addName(@PathVariable String name) {
    return Database.names.add(name) ? name : null;
  }

  @GetMapping(value = "/database/names")
  public List<String> getNames() {
    return Database.names;
  }

  // get name by index, if not foudn, return "not found"
  // if index is invald, return "wrong value"

  @GetMapping(value = "/database/index/{index}")
  public String getNameByIndex(@PathVariable String index){ // ! by default
    //String -> Integer
    try {
      int idx = Integer.valueOf(index);
      if (idx < 0 || idx >= Database.names.size()) {
        return "Wrong index.";
      }
      return Database.names.get(idx);
    } catch (NumberFormatException e) {
      return "Wrong index.";
    }

  }

  // delete name by name
  @DeleteMapping(value = "/database/{name}") // same pathway as line 32? No!
  //@GetMapping(value = "/database/delete/{name}")
  public String deleteName(@PathVariable String name) {
    return Database.names.remove(name) ? name + " deleted" : null;
  }
  
  // update name by Index + New Name
  @PutMapping(value = "/database/index/{index}/newname/{newname}")
  public String updateName(@PathVariable String index, 
      @PathVariable(value = "newname") String newName) {
    try {
      int idx = Integer.valueOf(index);
      if (idx < 0 || idx >= Database.names.size()) {
        return "Wrong index.";
      }
      return "changed " + Database.names.set(idx, newName) + " to " + newName;

    } catch (NumberFormatException e) {
      return "Wrong index.";
    }
  }
}
