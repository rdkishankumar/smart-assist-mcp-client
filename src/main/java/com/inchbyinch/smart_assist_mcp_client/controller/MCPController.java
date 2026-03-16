package com.inchbyinch.smart_assist_mcp_client.controller;

import com.inchbyinch.smart_assist_mcp_client.service.MCPService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class MCPController {

    private final MCPService mcpService;
    public MCPController(MCPService mcpService) {
        this.mcpService = mcpService;
    }

    @GetMapping("/chat")
    public ResponseEntity<String> chat(String message) {
        return ResponseEntity.ok(mcpService.chat(message));
    }

}
