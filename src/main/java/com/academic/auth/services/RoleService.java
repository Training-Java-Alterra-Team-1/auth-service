package com.academic.auth.services;

import com.academic.auth.dto.RoleDto;
import com.academic.auth.models.Roles;
import com.academic.auth.repositories.RoleRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional(rollbackOn = Exception.class)
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    @SneakyThrows(Exception.class)
    public ResponseEntity<Object> addRole(RoleDto request){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Roles role = new Roles();
        role.setName(request.getName());
        LocalDateTime todayDateTime = LocalDateTime.now();
        role.setCreatedAt(todayDateTime);

        roleRepository.save(role);

        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(role);
    }

    @SneakyThrows(Exception.class)
    public ResponseEntity<Object> getAllRoles() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        List<Roles> resp = roleRepository.findAll();

        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(resp);
    }

    @SneakyThrows(Exception.class)
    public ResponseEntity<Object> getRoleById(Long roleId){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Roles role = roleRepository.findRoleById(roleId);

        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(role);
    }
}