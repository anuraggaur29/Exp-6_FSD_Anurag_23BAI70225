package com.exp6.jwtauth.service;

import java.time.Instant;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Service;

@Service
public class TokenBlacklistService {

    private final Map<String, Instant> blacklistedTokens = new ConcurrentHashMap<>();

    public void blacklistToken(String token, Instant expiryTime) {
        blacklistedTokens.put(token, expiryTime);
    }

    public boolean isBlacklisted(String token) {
        cleanupExpiredEntries();
        return blacklistedTokens.containsKey(token);
    }

    private void cleanupExpiredEntries() {
        Instant now = Instant.now();
        blacklistedTokens.entrySet().removeIf(entry -> entry.getValue().isBefore(now));
    }
}
