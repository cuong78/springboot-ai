package com.anhcuong.spring_ai.controller;

import com.anhcuong.spring_ai.dto.ChatRequest;
import com.anhcuong.spring_ai.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {
    @Autowired
    ChatService chatService;
    @PostMapping("/chat")
    String chat (@RequestBody ChatRequest chatRequest) {
        return chatService.chat(chatRequest);
    }
}
