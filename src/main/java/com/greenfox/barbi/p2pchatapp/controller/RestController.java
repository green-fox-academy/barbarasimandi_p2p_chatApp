package com.greenfox.barbi.p2pchatapp.controller;

import com.greenfox.barbi.p2pchatapp.model.Log;
import com.greenfox.barbi.p2pchatapp.model.Message;
import com.greenfox.barbi.p2pchatapp.model.Received;
import com.greenfox.barbi.p2pchatapp.repository.MessageRepository;
import com.greenfox.barbi.p2pchatapp.service.LogService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@org.springframework.web.bind.annotation.RestController
public class RestController {

  @Autowired
  LogService logService;

  @Autowired
  MessageRepository messageRepository;

  @CrossOrigin("*")
  @PostMapping(value = "/api/message/receive")
  public Object receive(HttpServletRequest request, @RequestBody Received received) {
    logService.checkEnvironment(request);
    Log log = new Log(request);

    return received;
  }
}
