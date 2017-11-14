package com.greenfox.barbi.p2pchatapp.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ChatUser {

    @Id
    private String userName;

    @OneToMany
    List<Message> messages;

    public ChatUser(String userName, List<Message> messages) {
        this.messages = messages;
        this.userName = userName;
    }

    public ChatUser(String userName) {
        this.userName = userName;
    }

    public ChatUser() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
