package com.greenfox.barbi.p2pchatapp.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ChatUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    String username;

//    @OneToMany(fetch = FetchType.EAGER)
//    List<Message> messages;

//    public ChatUser(String userName, List<Message> messages) {
//        this.messages = messages;
//        this.userName = userName;
//    }

    public ChatUser(String username) {
        this.username = username;
    }

    public ChatUser() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

//    public List<Message> getMessages() {
//        return messages;
//    }
//
//    public void setMessages(List<Message> messages) {
//        this.messages = messages;
//    }
}
