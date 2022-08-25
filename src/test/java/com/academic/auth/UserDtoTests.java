package com.academic.auth;

import com.academic.auth.dto.UserDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserDtoTests {
    @Test
    public void testRoleDto() {
        UserDto user  = new UserDto("djodi", "djodi12321", new Long(1));
        assertEquals(user.getUsername(), "djodi");
        assertEquals(user.getPassword(), "djodi12321");
        assertEquals(user.getRoleId(), new Long(1));
    }
}
