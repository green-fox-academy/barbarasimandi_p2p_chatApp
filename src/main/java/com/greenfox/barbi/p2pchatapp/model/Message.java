package com.greenfox.barbi.p2pchatapp.model;

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
  @GeneratedValue(strategy = GenerationType.AUTO)
  int id;

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "chat_user_id")
  ChatUser user;

  String text;

  public Message(ChatUser user, String text) {
    this.user = user;
    this.text = text;
  }

  public Message(String text) {
    this.text = text;
  }

  public Message() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public ChatUser getUser() {
    return user;
  }

  public void setUser(ChatUser user) {
    this.user = user;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }
}
