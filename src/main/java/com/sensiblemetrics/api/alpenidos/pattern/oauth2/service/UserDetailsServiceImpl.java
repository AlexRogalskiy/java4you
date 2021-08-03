package com.sensiblemetrics.api.alpenidos.pattern.oauth2.service;

import com.sensiblemetrics.api.alpenidos.pattern.oauth2.model.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
@Profile("default")
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(final String username) {
        final com.sensiblemetrics.api.alpenidos.pattern.oauth2.model.User dbUser = this.userService.findByEmail(username);
        if (dbUser == null) {
            throw new UsernameNotFoundException(String.format("User '%s' can not be found", username));
        }
        return new User(dbUser.getEmail(), dbUser.getPassword(), dbUser.isActive(), true, true, true, this.loadAuthorities(dbUser));
    }

    private Collection<GrantedAuthority> loadAuthorities(final com.sensiblemetrics.api.alpenidos.pattern.oauth2.model.User user) {
        final Collection<Role> userAuthorities = user.getRoles();
        return userAuthorities.stream().map(userAuthority -> new SimpleGrantedAuthority(userAuthority.getRole())).collect(Collectors.toCollection(ArrayList::new));
    }

}
