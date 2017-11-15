package com.greenfox.barbi.p2pchatapp.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class AnswerStatus {

  String status;

  @JsonInclude(Include.NON_NULL)
  String message;

  public AnswerStatus(String status, String message) {
    this.status = status;
    this.message = message;
  }

  public AnswerStatus(String status) {
    this.status = status;
  }

  public AnswerStatus() {
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
