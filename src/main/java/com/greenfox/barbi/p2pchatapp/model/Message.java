package com.greenfox.barbi.p2pchatapp.model;

import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Message {

  @Id
  int id;

//  @ManyToOne(fetch = FetchType.EAGER)
//  @JoinColumn(name = "chat_user_id")
//  ChatUser user;

  String userName;

  String text;

  Timestamp timestamp;

  public Message(String userName, String text) {
    this.id = (int) (1000000 + (Math.random() * 8999999));
    this.userName = userName;
    this.text = text;
    this.timestamp = new Timestamp(System.currentTimeMillis());
  }

  public Message() {
    this.id = (int) (1000000 + (Math.random() * 8999999));
    this.userName = "barbarasimandi";
    this.timestamp = new Timestamp(System.currentTimeMillis());
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

//  public ChatUser getUser() {
//    return user;
//  }
//
//  public void setUser(ChatUser user) {
//    this.user = user;
//  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public Timestamp getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Timestamp timestamp) {
    this.timestamp = timestamp;
  }

//  @Override
//  public String toString() {
//    return "message: {" + "\n" +
//        "id" + this.getId() + "\n" +
//        "username" + this.user.getUserName() + "\n" +
//        "text" + this.getText() + "\n" +
//        "timestamp" + this.getTimestamp() + "\n" +
//        "}";
//  }
}
