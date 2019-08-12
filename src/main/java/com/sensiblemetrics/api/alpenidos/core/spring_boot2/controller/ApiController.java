package com.sensiblemetrics.api.alpenidos.core.spring_boot2.controller;

import com.sensiblemetrics.api.alpenidos.core.spring_boot2.dao.FollowedRepository;
import com.sensiblemetrics.api.alpenidos.core.spring_boot2.jobs.FollowJob;
import com.sensiblemetrics.api.alpenidos.core.spring_boot2.model.Followed;
import com.sensiblemetrics.api.alpenidos.core.spring_boot2.model.FollowingAmount;
import com.sensiblemetrics.api.alpenidos.core.spring_boot2.service.FollowService;
import com.sensiblemetrics.api.alpenidos.core.spring_boot2.service.FollowingAmountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ApiController {
    private final FollowedRepository followPersistenceService;
    private final FollowingAmountService followingAmountService;
    private final FollowJob followJob;
    private final FollowService followService;

    @GetMapping("/health")
    public ResponseEntity<Map<String, Object>> health() {
        return new ResponseEntity(new HashMap<String, Object>() {{
            put("alive", true);
        }}, HttpStatus.OK);
    }

    @GetMapping("/followed")
    public ResponseEntity followed() {
        final List<Followed> followed = this.followPersistenceService.findAll();
        return new ResponseEntity<>(followed, HttpStatus.OK);
    }

    @GetMapping("/follow-stats")
    public ResponseEntity stats() {
        final Instant then = Instant.now().minusSeconds(2592000); // 30 days ago
        final List<FollowingAmount> followingAmounts = this.followingAmountService.findByCreatedGreaterThanOrderByCreatedAsc(then);
        return new ResponseEntity<>(followingAmounts, HttpStatus.OK);
    }
}
