package com.anhcuong.spring_ai.service;

import com.anhcuong.spring_ai.dto.ChatRequest;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatService {
    private final ChatClient chatClient;

    public ChatService(ChatClient.Builder builder) {
        chatClient = builder.build();
    }


    public String chat(ChatRequest chatRequest) {
        return chatClient.prompt(chatRequest.message())
                .call()
                .content();

    }
}
