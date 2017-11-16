package com.greenfox.barbi.p2pchatapp.model;

public class Client {

  private String id;

  public Client(String id) {
    this.id = id;
  }

  public Client() {
    this.id = System.getenv("CHAT_APP_UNIQUE_ID");
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }
}
