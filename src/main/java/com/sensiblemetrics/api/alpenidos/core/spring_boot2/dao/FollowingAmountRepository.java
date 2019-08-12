package com.sensiblemetrics.api.alpenidos.core.spring_boot2.dao;

import com.sensiblemetrics.api.alpenidos.core.spring_boot2.model.FollowingAmount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface FollowingAmountRepository extends JpaRepository<FollowingAmount, Long> {
    List<FollowingAmount> findByCreatedGreaterThanOrderByCreatedAsc(final Instant then);

    List<FollowingAmount> findByCreatedLessThanOrderByCreatedAsc(final Instant then);
}
