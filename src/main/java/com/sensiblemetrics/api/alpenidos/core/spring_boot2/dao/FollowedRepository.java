package com.sensiblemetrics.api.alpenidos.core.spring_boot2.dao;

import com.sensiblemetrics.api.alpenidos.core.spring_boot2.model.Followed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

@Repository
public interface FollowedRepository extends JpaRepository<Followed, Long> {

    Followed findByExternalId(final String externalId);

    List<Followed> findByFollowedLessThan(final Instant then);
}
