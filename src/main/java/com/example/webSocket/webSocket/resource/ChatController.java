package com.example.webSocket.webSocket.resource;

import com.example.webSocket.webSocket.model.ChatMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

import java.util.Objects;

@Controller
public class ChatController {

    /**
     * Look at the Import class of payLoad- This is not related with MVC.
     *
     * @MessageMapping - This will help us to map same url from client to our Server. This annotation
     * ensures that if a message sent to /chat.register destination , the register method is called.
     * PayLoad of message is bound to ChatMessage object.
     * @SendTo The return value is broadcast to all subscribers of /topic/public as specified in SendTo
     * annotation
     */
    @MessageMapping("/chat.register")
    @SendTo("/topic/public")
    public ChatMessage register(@Payload ChatMessage chatMessage,
                                SimpMessageHeaderAccessor headerAccessor) throws InterruptedException {
        Thread.sleep(1000);
        Objects.requireNonNull(headerAccessor.getSessionAttributes())
                .put("userName", chatMessage.getSender());
        return chatMessage;
    }

    @MessageMapping("/chat.send")
    @SendTo("/topic/public")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
        return chatMessage;
    }

}
