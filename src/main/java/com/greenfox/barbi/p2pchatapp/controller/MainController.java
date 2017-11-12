package com.greenfox.barbi.p2pchatapp.controller;

import com.greenfox.barbi.p2pchatapp.model.Log;
import com.greenfox.barbi.p2pchatapp.repository.LogRepository;
import com.greenfox.barbi.p2pchatapp.service.LogService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

  @Autowired
  LogService logService;

  @Autowired
  LogRepository logRepository;

  @GetMapping(value = "/index")
  public String index(HttpServletRequest request, Exception exception) {
    logService.checkEnvironment(request, exception);
    Log log = new Log(request);
    logRepository.save(log);
    return "index";
  }
}
