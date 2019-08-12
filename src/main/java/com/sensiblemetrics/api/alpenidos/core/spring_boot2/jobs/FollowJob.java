package com.sensiblemetrics.api.alpenidos.core.spring_boot2.jobs;

import com.sensiblemetrics.api.alpenidos.core.spring_boot2.service.FollowService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FollowJob {
    private final FollowService followService;

    @Scheduled(cron = "0 0/10 * * * ?") // Every 10 minutes
    public void run() throws Exception {
        this.followService.execute();
    }
}
