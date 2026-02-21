package de.gichinsan.pwdGenerator;

import de.gichinsan.pwdGenerator.controller.PwdController;
import de.gichinsan.pwdGenerator.model.Password;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PwdGeneratorApplicationTests {

    @LocalServerPort
    private int port;

    @Autowired
    private PwdController controller;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void contextLoads() {
        assertDoesNotThrow(() -> controller.getPassword(1, 1, 0, 0, 24));
    }

    @Test
    void pwdCreatedSize() {
        Password[] response = restTemplate.getForObject(
                "http://localhost:" + port + "/pwd/{length}",
                Password[].class,
                24
        );

        assertThat(response).isNotNull();
        assertThat(response.length).isGreaterThan(0);
        assertThat(response[0].getPassword()).hasSize(24);
    }

    @Test
    void pwdCreated() {
        Password[] response = restTemplate.getForObject(
                "http://localhost:" + port + "/pwd/{length}",
                Password[].class,
                24
        );

        assertThat(response).isNotNull();
        assertThat(response[0].getPassword()).isNotEmpty();
    }
}