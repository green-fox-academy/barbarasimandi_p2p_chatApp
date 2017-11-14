package com.greenfox.barbi.p2pchatapp.service;

import com.greenfox.barbi.p2pchatapp.model.Message;
import com.greenfox.barbi.p2pchatapp.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

  @Autowired
  MessageRepository messageRepository;

  public Iterable<Message> findMessages() {
    return messageRepository.findAll();
  }

}
