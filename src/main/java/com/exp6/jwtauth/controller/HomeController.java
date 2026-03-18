package com.exp6.jwtauth.controller;

import com.exp6.jwtauth.dto.MessageResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public ResponseEntity<MessageResponse> home() {
        return ResponseEntity.ok(new MessageResponse("Exp 6 JWT Auth Backend is live. Use /api/health to check status."));
    }
}
