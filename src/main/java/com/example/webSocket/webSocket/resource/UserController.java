package com.example.webSocket.webSocket.resource;

import com.example.webSocket.webSocket.mode.User;
import com.example.webSocket.webSocket.mode.UserResponse;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

  @MessageMapping("/user")
  @SendTo("/topic/user")
  public UserResponse getUser(User user) {
    return new UserResponse("Hi "+user.getName());
  }
}
