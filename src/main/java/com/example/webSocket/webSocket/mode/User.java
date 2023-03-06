package com.example.webSocket.webSocket.mode;

import lombok.Data;

@Data
public class User {

  private String name;

  public User(String name) {
    this.name = name;
  }

  public User() {
  }
}
