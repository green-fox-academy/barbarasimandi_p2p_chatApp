package com.greenfox.barbi.p2pchatapp.repository;

import com.greenfox.barbi.p2pchatapp.model.ChatUser;
import com.greenfox.barbi.p2pchatapp.model.Message;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository <Message, Integer> {
  List<Message> findByUser(ChatUser user);
}
