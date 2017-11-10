package com.greenfox.barbi.p2pchatapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

  @GetMapping(value = "/index")
  public String hello() {
    return "index";
  }
}
