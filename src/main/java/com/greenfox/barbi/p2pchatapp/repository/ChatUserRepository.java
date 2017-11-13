package com.greenfox.barbi.p2pchatapp.repository;

import com.greenfox.barbi.p2pchatapp.model.ChatUser;
import org.springframework.data.repository.CrudRepository;

public interface ChatUserRepository extends CrudRepository <ChatUser, String> {

}
