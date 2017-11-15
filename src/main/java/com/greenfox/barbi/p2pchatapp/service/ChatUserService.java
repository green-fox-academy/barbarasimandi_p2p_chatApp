package com.greenfox.barbi.p2pchatapp.service;

import com.greenfox.barbi.p2pchatapp.model.ChatUser;
import com.greenfox.barbi.p2pchatapp.repository.ChatUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatUserService {

  @Autowired
  ChatUserRepository chatUserRepository;

  public ChatUser findFirst() {
    return chatUserRepository.findOne(1l);
  }

  public Iterable<ChatUser> getUsers() {
    return chatUserRepository.findAll();
  }

  public void save(ChatUser user) {
    chatUserRepository.save(user);
  }
}
