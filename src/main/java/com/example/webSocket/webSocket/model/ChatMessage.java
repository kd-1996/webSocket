package com.example.webSocket.webSocket.model;

import lombok.Data;

@Data
public class ChatMessage {

  private String content;
  private String sender;

  private MessageType type;

  private enum MessageType {
    CHAT, LEFT, JOIN
  }

}
