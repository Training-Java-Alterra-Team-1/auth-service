package com.academic.auth.repositories;

import com.academic.auth.models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {
    public Users findByUsername(String username);
}
