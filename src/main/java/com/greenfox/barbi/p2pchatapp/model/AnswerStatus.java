package com.greenfox.barbi.p2pchatapp.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AnswerStatus {

  String status;

  @JsonInclude(Include.NON_NULL)
  String message;

  public AnswerStatus(HttpServletResponse response) {
    this.status = response.getStatus() != 200 ? "error" : "ok";
    this.message = status.equals("error") ? "Missing field(s): "
        + response.getHeaderNames().toString() : null;
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
