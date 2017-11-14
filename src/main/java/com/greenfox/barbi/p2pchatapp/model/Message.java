//package com.greenfox.barbi.p2pchatapp.model;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
//import javax.persistence.SequenceGenerator;
//
//@Entity
//public class Message {
//
//  @Id
//  Long id;
//
//  @ManyToOne
//  ChatUser user;
//
//  String message;
//
//  public Message(ChatUser user, String message) {
//    this.id = (long)(1000000 + Math.random() * 9999999);
//    this.user = user;
//    this.message = message;
//  }
//
//  public Message() {
//  }
//
//  public Long getId() {
//    return id;
//  }
//
//  public void setId(Long id) {
//    this.id = id;
//  }
//
//  public ChatUser getUser() {
//    return user;
//  }
//
//  public void setUser(ChatUser user) {
//    this.user = user;
//  }
//
//  public String getMessage() {
//    return message;
//  }
//
//  public void setMessage(String message) {
//    this.message = message;
//  }
//}
