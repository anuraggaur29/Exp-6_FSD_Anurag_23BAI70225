package com.exp6.jwtauth.controller;

import com.exp6.jwtauth.dto.MessageResponse;
import java.security.Principal;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ProtectedController {

    @GetMapping("/protected")
    public ResponseEntity<MessageResponse> protectedEndpoint(Principal principal) {
        String username = principal != null ? principal.getName() : "unknown";
        return ResponseEntity.ok(new MessageResponse("Protected data access granted for user: " + username));
    }

    @GetMapping("/health")
    public ResponseEntity<MessageResponse> health() {
        return ResponseEntity.ok(new MessageResponse("JWT Auth Backend is running"));
    }
}
