package com.example.webSocket.webSocket.config;

import com.example.webSocket.webSocket.model.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class SchedulerConfig {

    @Autowired
    SimpMessagingTemplate template;

    @Scheduled(fixedDelay = 5000)
    public void sendAdHocMessages() {
        template.convertAndSend("/topic/user", new UserResponse("Fixed delayed Scheduler"));
    }
}
