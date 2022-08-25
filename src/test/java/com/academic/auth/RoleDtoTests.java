package com.academic.auth;

import com.academic.auth.dto.RoleDto;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RoleDtoTests {
    @Test
    public void testRoleDto() {
        RoleDto role  = new RoleDto("TEST ROLE");
        assertEquals(role.getName(), "TEST ROLE");
    }
}
