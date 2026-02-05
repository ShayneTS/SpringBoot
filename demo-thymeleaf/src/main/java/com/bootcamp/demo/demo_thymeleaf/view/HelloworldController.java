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

  // repository
  @Autowired
  private CoinService coinService;

  @GetMapping(value = "/hello")
  public String firstPage(Model model){
    // read DB
    // this mode of developping front end is called server side rendering
    // control the frontend from the server side
    List<CoinDTO> coinDTOs = this.coinService.getCoins();
    model.addAttribute("coinList", coinDTOs);

    model.addAttribute("programming", "Java");
    return "helloworld";
  }
}
