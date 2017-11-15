package com.greenfox.barbi.p2pchatapp.controller;

import com.greenfox.barbi.p2pchatapp.model.AnswerStatus;
import com.greenfox.barbi.p2pchatapp.model.Log;
import com.greenfox.barbi.p2pchatapp.model.Message;
import com.greenfox.barbi.p2pchatapp.model.Received;
import com.greenfox.barbi.p2pchatapp.repository.MessageRepository;
import com.greenfox.barbi.p2pchatapp.service.LogService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

@org.springframework.web.bind.annotation.RestController
public class RestController {

  @Autowired
  LogService logService;

  @Autowired
  MessageRepository messageRepository;

  @CrossOrigin("*")
  @PostMapping(value = "/api/message/receive")
  public ResponseEntity receive(HttpServletRequest request, @RequestBody Received received) {

    RestTemplate restTemplate = new RestTemplate();

    logService.checkEnvironment(request);
    Log log = new Log(request);

    if (received.getMessage().getTimestamp() == null || received.getMessage().getText() == null || received.getMessage().getUsername() == null) {
      return new ResponseEntity(new AnswerStatus("error",  getMissingFields(received)), HttpStatus.UNAUTHORIZED);
    }
    else {
      messageRepository.save(received.getMessage());
      return new ResponseEntity(new AnswerStatus("ok"), HttpStatus.OK);
    }
  }

  public String getMissingFields(Received received) {
    StringBuilder sb = new StringBuilder();
    sb.append("Missing field(s): ");

    if (received.getMessage().getTimestamp() == null) {
      sb.append("message.timestamp");
    } else if (received.getMessage().getText() == null) {
      sb.append("message.text");
    } else if (received.getMessage().getUsername() == null) {
      sb.append("message.username");
    } else if (received.getClient().getId() == null) {
      sb.append("client.id");
    }
    return sb.toString();
  }
}
