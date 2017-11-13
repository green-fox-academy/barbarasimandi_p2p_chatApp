package com.greenfox.barbi.p2pchatapp.exception;

public class UserException {
  String error;

  public UserException() {
    this.error = "The username field is empty!";
  }

  public UserException(String error) {
    this.error = error;
  }

  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }
}
