package com.example.webSocket.webSocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

  @Override
  public void configureMessageBroker(MessageBrokerRegistry registry) {
    registry.enableSimpleBroker("/topic");
    registry.setApplicationDestinationPrefixes("/app");
    /**
     * Broker via which will be pushing messages inside message broker.
     */
  }

  @Override
  public void registerStompEndpoints(StompEndpointRegistry registry) {

    registry.addEndpoint("/websocket-example").withSockJS();
    /**
     * This is the webSocket which will be created for us. You can add multiple end points
     * Sock-js library to create webSockets
     * WebSocket is just a communication protocol. He doesn't know How to send a message only to users  who are subscribed to
     * a particular topic or how to send a message to a particular user.
     * STOMP - Streaming text oriented Messaging Protocol.
     * STOMP is simple text based protocol, it allows STOMP clients to talk with any message broker supporting the protocol.
     * Spring provides default support for it but we can choose any other messaging Protocol such as RabitMQ or ActiveMQ.
     */
  }
}
