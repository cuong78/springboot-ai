package com.anhcuong.spring_ai.controller;

import com.anhcuong.spring_ai.dto.BillItem;
import com.anhcuong.spring_ai.dto.ChatRequest;
import com.anhcuong.spring_ai.dto.ExpenseInfo;
import com.anhcuong.spring_ai.service.ChatService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class ChatController {
    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping("/chat")
    ExpenseInfo chat(@RequestBody ChatRequest request) {
        return chatService.chat(request);
    }

    @PostMapping("/chat-with-image")
    List<BillItem> chatWithImage(@RequestParam("file")MultipartFile file,
                                 @RequestParam("message") String message) {
        return chatService.chatWithImage(file, message);
    }
}