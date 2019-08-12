package com.sensiblemetrics.api.alpenidos.core.spring_boot2.service;

import com.sensiblemetrics.api.alpenidos.core.spring_boot2.dao.FollowingAmountRepository;
import com.sensiblemetrics.api.alpenidos.core.spring_boot2.model.FollowingAmount;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FollowingAmountService {
    private final FollowingAmountRepository followingAmountRepository;

    public void saveFollowingAmounts(long imFollowing, long myFollowers) {
        final FollowingAmount followingAmount = new FollowingAmount(imFollowing, myFollowers);
        followingAmountRepository.save(followingAmount);
    }

    public List<FollowingAmount> findByCreatedGreaterThanOrderByCreatedAsc(Instant then) {
        return followingAmountRepository.findByCreatedGreaterThanOrderByCreatedAsc(then);
    }

    public List<FollowingAmount> findByCreatedLessThanOrderByCreatedAsc(Instant then) {
        return followingAmountRepository.findByCreatedLessThanOrderByCreatedAsc(then);
    }

    public void delete(FollowingAmount followingAmount) {
        followingAmountRepository.delete(followingAmount);
    }
}
