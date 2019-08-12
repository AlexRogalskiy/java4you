package com.sensiblemetrics.api.alpenidos.core.spring_boot2.jobs;

import com.sensiblemetrics.api.alpenidos.core.spring_boot2.dao.FollowedRepository;
import com.sensiblemetrics.api.alpenidos.core.spring_boot2.model.Followed;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Slf4j
@Component
public class FollowedCleanupJob {
    private FollowedRepository followedRepository;
    private int limit;

    @Autowired
    public FollowedCleanupJob(final FollowedRepository followedRepository) {
        this.followedRepository = followedRepository;
        this.limit = 8500;
    }

    //    @Scheduled(cron = "0 55 23 * * ?") // 23:59
    @Scheduled(cron = "0 0 0/3 * * ?") // Every 3 hours
    public List<Followed> cleanup() {
        log.info("Starting cleanup");
        final List<Followed> followedList = this.followedRepository.findAll();
        if (followedList.size() > limit) {
            int elementsToRemove = followedList.size() - limit;
            Iterator<Followed> itr = followedList.iterator();
            List<Followed> removeElements = new ArrayList<>();
            int i = 0;
            while (itr.hasNext() && i < elementsToRemove) {
                Followed followed = itr.next();
                followedRepository.delete(followed);
                removeElements.add(followed);
                i++;
            }
            followedList.removeAll(removeElements);
        }
        log.info("Done with the cleanup");
        return followedList;
    }
}
