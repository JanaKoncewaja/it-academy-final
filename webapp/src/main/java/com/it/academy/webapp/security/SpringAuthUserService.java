package com.it.academy.webapp.security;

import com.it.academy.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class SpringAuthUserService implements UserDetailsService {

    private final UserService userService;


    @Autowired
    public SpringAuthUserService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.it.academy.domain.user.User appUser = userService.getUserByName(username);

        if (appUser == null) {
            throw new UsernameNotFoundException("Username " + username + " not found");
        }

        return new User(appUser.getUsername(), appUser.getPassword(),
                Collections
                        .singletonList
                                (new SimpleGrantedAuthority("ROLE_" + appUser.getRole().getRoleName().name())));
    }
}
