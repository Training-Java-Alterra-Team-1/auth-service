package com.academic.auth;

import static org.assertj.core.api.Assertions.assertThat;

import com.academic.auth.controllers.RoleController;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RoleControllerTests {

    @LocalServerPort
    private int port;
    @Autowired
    private RoleController controller;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

    @Test
    public void shouldReturnError() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/roles",
                String.class)).contains("error");
    }
}
