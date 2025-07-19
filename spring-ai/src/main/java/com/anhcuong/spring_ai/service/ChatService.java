package com.anhcuong.spring_ai.service;

import com.anhcuong.spring_ai.dto.BillItem;
import com.anhcuong.spring_ai.dto.ChatRequest;
import com.anhcuong.spring_ai.dto.ExpenseInfo;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.SystemMessage;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.ChatOptions;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.content.Media;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@Service
public class ChatService {
    private final ChatClient chatClient;

    public ChatService(ChatClient.Builder builder) {
        chatClient = builder.build();
    }

    public List<BillItem> chatWithImage(MultipartFile file, String message) {
        Media media = Media.builder()
                .mimeType(MimeTypeUtils.parseMimeType(file.getContentType()))
                .data(file.getResource())
                .build();

        ChatOptions chatOptions = ChatOptions.builder()
                .temperature(0D)
                .build();

        return chatClient.prompt()
                .options(chatOptions)
                .system("You are Devteria.AI")
                .user(promptUserSpec
                        -> promptUserSpec.media(media)
                        .text(message))
                .call()
                .entity(new ParameterizedTypeReference<List<BillItem>>() {
                });
    }

    public ExpenseInfo chat(ChatRequest request) {
        SystemMessage systemMessage = new SystemMessage("""
                You are Devteria.AI
                You should response with a formal voice
                """);

        UserMessage userMessage = new UserMessage(request.message());

        Prompt prompt = new Prompt(systemMessage, userMessage);

        return chatClient
                .prompt(prompt)
                .call()
                .entity(ExpenseInfo.class);
    }
}