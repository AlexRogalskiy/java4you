package com.sensiblemetrics.api.alpenidos.pattern.oauth2.service;

import com.sensiblemetrics.api.alpenidos.pattern.oauth2.model.Role;
import com.sensiblemetrics.api.alpenidos.pattern.oauth2.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;

    public Role findByRole(final String roleStr) {
        return this.roleRepository.findByRole(roleStr);
    }

    public Role saveRole(final String role) {
        final Role roleObj = new Role(role);
        this.roleRepository.save(roleObj);
        return roleObj;
    }
}
