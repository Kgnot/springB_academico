package com.frenos_el_control.principal.security.service;

import com.frenos_el_control.principal.entity.user.UserFEC;
import com.frenos_el_control.principal.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserService userService;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final UserFEC userFEC = userService.findByName(username);
        if (userFEC == null) {
            throw new UsernameNotFoundException("Unknown user with name: " + username);
        }

        return org.springframework.security.core.userdetails.User.withUsername(userFEC.getName())
                .password(userFEC.getPassword())
                .accountExpired(false)
                .accountLocked(false)
                .credentialsExpired(false)
                .disabled(false)
                .build();
    }
}
