package com.exp6.jwtauth.config;

import com.exp6.jwtauth.entity.User;
import com.exp6.jwtauth.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner seedDefaultUser(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if (!userRepository.existsByUsername("user123")) {
                userRepository.save(new User("user123", passwordEncoder.encode("password123")));
            }
        };
    }
}
