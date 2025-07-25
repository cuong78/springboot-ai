package com.anhcuong.spring_ai.controller;

import com.anhcuong.spring_ai.dto.ChatRequest;
import com.anhcuong.spring_ai.service.ChatService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {
    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping("/chat")
    String chat(@RequestBody ChatRequest request) {
        return chatService.chat(request);
    }
}