package com.greenfox.barbi.p2pchatapp.repository;

import com.greenfox.barbi.p2pchatapp.model.ChatUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface ChatUserRepository extends CrudRepository <ChatUser, Long> {

}
