package com.academic.auth.services;

import com.academic.auth.models.Roles;
import com.academic.auth.models.Users;
import com.academic.auth.repositories.RoleRepository;
import com.academic.auth.repositories.UserRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
@Transactional(rollbackOn = Exception.class)
public class InitialDataService {
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @SneakyThrows(Exception.class)
    public ResponseEntity<Object> addUser(Users user) {
        Users foundData = userRepository.findByUsername(user.getUsername());
        if(foundData == null) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            LocalDateTime currentDateTime = LocalDateTime.now();
            user.setCreatedAt(currentDateTime);
            userRepository.save(user);
        }

        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @SneakyThrows(Exception.class)
    public void addRoleToUser(String username, String roleName) {
        Users user = userRepository.findByUsername(username);
        Roles role = roleRepository.findByName(roleName);

        user.setRoleId(role.getId());

        userRepository.save(user);
    }

    @SneakyThrows(Exception.class)
    public ResponseEntity<Object> addRole(Roles role) {
        Roles foundData = roleRepository.findByName(role.getName());
        if(foundData == null) {
            LocalDateTime currentDateTime = LocalDateTime.now();
            role.setCreatedAt(currentDateTime);
            roleRepository.save(role);
        }

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
