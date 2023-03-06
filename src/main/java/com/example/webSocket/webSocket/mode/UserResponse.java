package com.example.webSocket.webSocket.mode;

import lombok.Data;

@Data
public class UserResponse {

  String content;

  public UserResponse(String content) {
    this.content = content;
  }

  public UserResponse() {
  }
}
