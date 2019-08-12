package com.sensiblemetrics.api.alpenidos.core.oauth2.controller;

import com.sensiblemetrics.api.alpenidos.core.oauth2.model.User;
import com.sensiblemetrics.api.alpenidos.core.oauth2.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class ApiUserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<Map<String, Object>> userDetails() {
        final User currentUser = this.userService.getCurrentUser();
        final Map<String, Object> out = new HashMap<>() {{
            put("id", currentUser.getId());
            put("email", currentUser.getEmail());
            put("passwordHash", currentUser.getPassword());
        }};
        return new ResponseEntity<>(out, HttpStatus.OK);
    }
}
