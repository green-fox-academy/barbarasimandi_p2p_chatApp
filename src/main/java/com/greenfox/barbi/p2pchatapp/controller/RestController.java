package com.greenfox.barbi.p2pchatapp.controller;

import com.greenfox.barbi.p2pchatapp.model.Log;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {

  @GetMapping(value = "/")
  public String log(HttpServletRequest request) {
    Log log = new Log(request);
    return log.toString();
  }
}
