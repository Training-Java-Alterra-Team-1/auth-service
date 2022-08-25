package com.academic.auth.repositories;

import com.academic.auth.models.Roles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Roles, Long> {
    Roles findRoleById(Long roleId);
    Roles findByName(String name);
}
