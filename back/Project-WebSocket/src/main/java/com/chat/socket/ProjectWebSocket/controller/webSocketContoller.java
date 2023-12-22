package com.chat.socket.ProjectWebSocket.controller;

import com.chat.socket.ProjectWebSocket.dto.chatMessage;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class webSocketContoller {

    @MessageMapping("/chat/{roomId}")
    @SendTo("/topic/{roomId}")
    public chatMessage chat (@DestinationVariable String roomId, chatMessage message){
        System.out.println(message);
        return new chatMessage(message.getMessage(), message.getUser());



    }
}
