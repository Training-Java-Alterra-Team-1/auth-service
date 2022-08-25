package com.academic.auth;

import com.academic.auth.models.Roles;
import com.academic.auth.repositories.RoleRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RoleJPATests {
    @Autowired
    private RoleRepository roleRepository;

    @Test
    @Order(1)
    public void testCreateRole() {
        Roles role = new Roles();
        role.setName("TEST ROLE");

        Roles result = roleRepository.save(role);
        assertNotNull(result);
    }

    @Test
    @Order(2)
    public void testGetRole() {
        testCreateRole();
        Roles role = roleRepository.findByName("TEST ROLE");
        assertNotEquals(0, role.getId());
    }

    @Test
    @Order(3)
    public void testGetRoles() {
        List<Roles> roles = roleRepository.findAll();
        assertThat(roles).size().isGreaterThan(0);
    }

    @Test
    @Order(4)
    public void testUpdateRole() {
        testCreateRole();
        Roles role = roleRepository.findByName("TEST ROLE");

        role.setName("NON TEST ROLE");

        Roles result = roleRepository.save(role);
        assertEquals("NON TEST ROLE", result.getName().trim());
    }

    @Test
    @Order(5)
    public void testDeleteRole() {
        testCreateRole();
        Roles role = roleRepository.findByName("TEST ROLE");
        roleRepository.delete(role);
        assertNull(roleRepository.findByName("TEST ROLE"));
    }
}
