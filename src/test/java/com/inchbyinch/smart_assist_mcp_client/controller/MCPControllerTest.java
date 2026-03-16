package com.inchbyinch.smart_assist_mcp_client.controller;

import com.inchbyinch.smart_assist_mcp_client.service.MCPService;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

class MCPControllerTest {

    @Test
    void chatReturnsServiceResponse() {
        MCPService stubService = message -> "service:" + message;
        MCPController controller = new MCPController(stubService);

        ResponseEntity<String> response = controller.chat("hello");

        assertNotNull(response);
        assertEquals(200, response.getStatusCode().value());
        assertEquals("service:hello", response.getBody());
    }

    @Test
    void chatPassesNullToService() {
        class CaptureService implements MCPService {
            String lastMessage = "not-set";

            @Override
            public String chat(String message) {
                this.lastMessage = message;
                return "ok";
            }
        }

        CaptureService svc = new CaptureService();
        MCPController controller = new MCPController(svc);

        ResponseEntity<String> response = controller.chat(null);

        assertEquals("ok", response.getBody());
        assertNull(svc.lastMessage);
    }

}
