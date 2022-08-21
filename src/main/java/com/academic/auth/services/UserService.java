package com.academic.auth.services;

import com.academic.auth.models.Users;
import com.academic.auth.repositories.UserRepository;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Service
@Transactional(rollbackOn = { SQLException.class, Exception.class })
@Slf4j
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    @SneakyThrows(UsernameNotFoundException.class)
    public UserDetails loadUserByUsername(String username) {
        val user = userRepository.findByUsername(username);

        if (Optional.ofNullable(user).isPresent()) {
            Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
            return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
        } else {
            throw new UsernameNotFoundException("user " + username + " is not available in the database");
        }
    }

    @SneakyThrows(Exception.class)
    public Users addUser(Users user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        LocalDateTime currentDateTime = LocalDateTime.now();
        user.setCreatedAt(currentDateTime);

        return userRepository.save(user);
    }

    @SneakyThrows(Exception.class)
    public Users getUser(String username) {
        return userRepository.findByUsername(username);
    }
}
