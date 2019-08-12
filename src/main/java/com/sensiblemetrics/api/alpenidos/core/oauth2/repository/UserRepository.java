package com.sensiblemetrics.api.alpenidos.core.oauth2.repository;

import com.sensiblemetrics.api.alpenidos.core.oauth2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(final String email);
}
