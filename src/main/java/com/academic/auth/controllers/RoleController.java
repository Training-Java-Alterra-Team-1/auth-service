package com.academic.auth.controllers;

import com.academic.auth.services.RoleService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@Slf4j
@SecurityRequirement(name = "academicauthservice")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @SneakyThrows(Exception.class)
    @GetMapping(path = "/roles", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getAllRoles(){
        log.info("api GET /api/v1/roles is hit.");
        return roleService.getAllRoles();
    }
}
