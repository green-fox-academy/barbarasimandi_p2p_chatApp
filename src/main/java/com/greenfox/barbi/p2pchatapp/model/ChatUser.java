package com.greenfox.barbi.p2pchatapp.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ChatUser {

    @Id
    private String userName;

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
}
