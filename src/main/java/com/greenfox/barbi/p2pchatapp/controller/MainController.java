package com.greenfox.barbi.p2pchatapp.controller;

import com.greenfox.barbi.p2pchatapp.model.ChatUser;
import com.greenfox.barbi.p2pchatapp.model.Log;
import com.greenfox.barbi.p2pchatapp.repository.ChatUserRepository;
import com.greenfox.barbi.p2pchatapp.repository.LogRepository;
import com.greenfox.barbi.p2pchatapp.service.LogService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

  @Autowired
  ChatUserRepository chatUserRepository;

  @Autowired
  LogRepository logRepository;

  @Autowired
  LogService logService;

  @GetMapping(value = "/")
  public String index() {
    return "index";
  }

  @GetMapping(value = "/enter")
  public String enter() {
    ChatUser user = new ChatUser();
    return "enter";
  }

  @GetMapping(value = "/enter/user")
  public String enter(@RequestParam String userName, HttpServletRequest request) {
    logService.checkEnvironment(request);
    Log log = new Log(request);
    logRepository.save(log);
    ChatUser user = new ChatUser(userName);
    chatUserRepository.save(user);
    return "enter";
  }
}
