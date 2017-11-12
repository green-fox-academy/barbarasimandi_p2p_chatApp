package com.greenfox.barbi.p2pchatapp.controller;

import com.greenfox.barbi.p2pchatapp.model.Log;
import com.greenfox.barbi.p2pchatapp.repository.LogRepository;
import com.greenfox.barbi.p2pchatapp.service.LogService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {

  @Autowired
  LogService logService;

  @Autowired
  LogRepository logRepository;

  @GetMapping(value = "/")
  public void log(HttpServletRequest request) {
    logService.checkEnvironment(request);
    Log log = new Log(request);
    logRepository.save(log);

  }
}
