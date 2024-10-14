package com.gfreitas.blog.EventDrivenBlog.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.gfreitas.blog.EventDrivenBlog.Event.*;
import com.gfreitas.blog.EventDrivenBlog.Model.*;

@RestController
public class MessageController {

    private final SimpMessagingTemplate messagingTemplate;

    @Autowired
    public MessageController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @PostMapping("/send-message")
    public void sendMessage(@RequestBody MessageRequest messageRequest) {
        messagingTemplate.convertAndSend("/topic/events", new MessageEvent(messageRequest.getMessage()));
    }
}

