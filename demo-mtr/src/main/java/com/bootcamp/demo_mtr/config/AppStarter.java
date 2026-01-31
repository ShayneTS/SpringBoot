package com.bootcamp.demo_mtr.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.bootcamp.demo_mtr.service.MTRService;

@Component
public class AppStarter implements CommandLineRunner{

  @Autowired
  private MTRService mtrService;

  @Override
  public void run(String... args) throws Exception{
    this.mtrService.deleteAllLines();
    this.mtrService.deleteAllStaitons();

    // insert lines & stations
    this.mtrService.saveLine("AEL","Airport Express");
    this.mtrService.saveLine("TCL","Tung Chung Line");
    // check service > MTR Service for .saveStation
    this.mtrService.saveStation("AEL", "HOK", "Hong Kong", null, "KOW");
    this.mtrService.saveStation("AEL", "KOW", "Kowloon", "HOK", " TSY");
    this.mtrService.saveStation("AEL", "TSY", "Tsing Yi", "KOW", "AIR");
    this.mtrService.saveStation("AEL", "AIR", "Airport", "TSY", "AWE");
    this.mtrService.saveStation("AEL", "AWE", "AsiaWorld Expo", "AIR", null);

    this.mtrService.saveStation("TCL", "HOK", "Hong Kong", null, "KOW");
    this.mtrService.saveStation("TCL", "KOW", "Kowloon", "HOK", "OLY");
    this.mtrService.saveStation("TCL", "OLY", "Olympic", "KOW", "NAC");
    this.mtrService.saveStation("TCL", "NAC", "Nam Cheong", "OLY", "LAK");
    this.mtrService.saveStation("TCL", "LAK", "Lai King", "NAC", "TSY");
    this.mtrService.saveStation("TCL", "TSY", "Tsing Yi", "LAK", "SUN");
    this.mtrService.saveStation("TCL", "SUN", "Sunny Bay", "TSY", "TUC");
    this.mtrService.saveStation("TCL", "TUC", "Tung Chung", "SUN", null);


  }
}
