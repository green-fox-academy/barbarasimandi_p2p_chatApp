package com.greenfox.barbi.p2pchatapp.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ChatUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String userName;

//    @OneToMany
//    List<Message> messages;
//
//    public ChatUser(String userName, List<Message> messages) {
//        this.messages = messages;
//        this.userName = userName;
//    }

    public ChatUser(String userName) {
        this.userName = userName;
    }

    public ChatUser() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

//    public List<Message> getMessages() {
//        return messages;
//    }
//
//    public void setMessages(List<Message> messages) {
//        this.messages = messages;
//    }
}
