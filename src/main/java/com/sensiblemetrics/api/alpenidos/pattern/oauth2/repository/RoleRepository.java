package com.sensiblemetrics.api.alpenidos.pattern.oauth2.repository;

import com.sensiblemetrics.api.alpenidos.pattern.oauth2.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByRole(final String role);
}
