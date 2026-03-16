package com.inchbyinch.smart_assist_mcp_client.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.client.advisor.api.Advisor;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class MCPConfig {

    private final ChatClient.Builder chatClientBuilder;
    private final ToolCallbackProvider toolCallbackProvider;

    public MCPConfig(ChatClient.Builder chatClientBuilder, ToolCallbackProvider toolCallbackProvider) {
        this.toolCallbackProvider = toolCallbackProvider;
        this.chatClientBuilder = chatClientBuilder;
    }

    @Bean
    public ChatClient chatClient() {
        Advisor simpleLoggerAdvisor = new SimpleLoggerAdvisor();
        return chatClientBuilder
                .defaultToolCallbacks(toolCallbackProvider)
                .defaultAdvisors(List.of(simpleLoggerAdvisor))
                .build();
    }
}
