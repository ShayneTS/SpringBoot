package com.bootcamp.demo.demo_thymeleaf.view;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.bootcamp.demo.demo_thymeleaf.model.dto.CoinDTO;
import com.bootcamp.demo.demo_thymeleaf.service.CoinService;



@Controller // non-json (html, xml, etc)
public class HelloworldController {

  @Autowired
  private CoinService coinService;

  @GetMapping(value = "/hello")
  public String firstPage(Model model) {

    List<CoinDTO> coinDTOs = this.coinService.getCoins();
    model.addAttribute("coinList", coinDTOs);

    model.addAttribute("programming", "Java");
    return "helloworld"; // html file name
  }

  // @GetMapping(value = "/refresh")
  // public String firstPage(Model model) {

  //   List<CoinDTO> coinDTOs = this.coinService.getCoins();
  //   model.addAttribute("coinList", coinDTOs);

  //   model.addAttribute("programming", "Java");
  //   return "helloworld"; // html file name
  // }
}