package com.sensiblemetrics.api.alpenidos.core.spring_boot2;

import com.sensiblemetrics.api.alpenidos.core.spring_boot2.service.FollowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Application implements CommandLineRunner {

    @Autowired
    private FollowService followService;

    public static void main(final String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(final String... strings) {
        try {
            followService.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
