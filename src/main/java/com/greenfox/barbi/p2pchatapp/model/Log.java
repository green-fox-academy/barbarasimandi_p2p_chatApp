package com.greenfox.barbi.p2pchatapp.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.servlet.http.HttpServletRequest;

@Entity
public class Log {

  @Id
  Long id;

  String path;
  String method;
  String createdAt;
  String level;
  String param;

  public Log(HttpServletRequest request) {
    this.id = (long)(1000 + Math.random() * 10000);
    this.path = request.getServletPath();
    this.method = request.getMethod();
    this.createdAt = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
    this.level = System.getenv("CHAT_APP_LOGLEVEL");
    this.param = request.getQueryString();
  }

  public Log() {

  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public String getMethod() {
    return method;
  }

  public void setMethod(String method) {
    this.method = method;
  }

  public String getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }

  public String getLevel() {
    return level;
  }

  public void setLevel(String level) {
    this.level = level;
  }

  public String getParam() {
    return param;
  }

  public void setParam(String param) {
    this.param = param;
  }

  public String toString() {
    return createdAt + " " + level + " " + path + " " + method + " " + param;
  }
}
