package com.inchbyinch.smart_assist_mcp_client.service.impl;

import com.inchbyinch.smart_assist_mcp_client.service.MCPService;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class MCPServiceImpl implements MCPService {
    private final ChatClient chatClientBuilder;
    public MCPServiceImpl(ChatClient chatClientBuilder) {
        this.chatClientBuilder = chatClientBuilder;
    }

    @Override
    public String chat(String message) {
        return chatClientBuilder.prompt()
                .user(message)
                .call()
                .content();
    }
}
