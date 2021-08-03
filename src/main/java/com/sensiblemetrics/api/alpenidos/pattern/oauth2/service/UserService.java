package com.sensiblemetrics.api.alpenidos.pattern.oauth2.service;

import com.sensiblemetrics.api.alpenidos.pattern.oauth2.model.Role;
import com.sensiblemetrics.api.alpenidos.pattern.oauth2.model.User;
import com.sensiblemetrics.api.alpenidos.pattern.oauth2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class UserService {
    private static String ROLE_USER = "ROLE_USER";

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private RoleService roleService;

    public User createUser(final String email, final String password) {
        User user = this.userRepository.findByEmail(email);
        if (user == null) {
            user = new User(email, hashPassword(password), new ArrayList<>(), true);
            addRoleToUser(user, ROLE_USER);
            this.userRepository.save(user);
            return user;
        }
        return null;
    }

    private void addRoleToUser(User user, String roleStr) {
        Role role = this.roleService.findByRole(roleStr);
        if (role == null) {
            role = this.roleService.saveRole(roleStr);
        }
        user.getRoles().add(role);
    }

    private String hashPassword(final String password) {
        return passwordEncoder.encode(password);
    }

    public User getCurrentUser() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUserName = null;
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            currentUserName = authentication.getName();
        }
        User user = null;
        if (currentUserName != null) {
            user = findByEmail(currentUserName);
        }
        return user;
    }

    public User findByEmail(final String email) {
        return this.userRepository.findByEmail(email);
    }
}
