package com.sensiblemetrics.api.alpenidos.pattern.oauth2;

import com.sensiblemetrics.api.alpenidos.pattern.oauth2.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@Slf4j
@SpringBootApplication
@RequiredArgsConstructor
public class Application implements CommandLineRunner {
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;

    public static void main(final String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(final String... strings) {
        log.info("Attempting to create a test user");
//		System.out.println(passwordEncoder.encode("project_pass"));
        this.userService.createUser("email@email.com", "password");
    }
}
