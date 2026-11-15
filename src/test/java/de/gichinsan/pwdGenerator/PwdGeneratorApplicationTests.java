package de.gichinsan.pwdGenerator;

import de.gichinsan.pwdGenerator.model.Password;
import org.junit.jupiter.api.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PwdGeneratorApplicationTests {

    @LocalServerPort
    private int port;

    private final RestTemplate restTemplate = new RestTemplate();

    @Test
    void contextLoads() {
        // Der Controller wird über HTTP aufgerufen, nicht direkt
        // Direkt aufrufen ist schwierig wegen @PathVariable
    }

    @Test
    void pwdCreatedSize() {
        List<Password> response = restTemplate.exchange(
                "http://localhost:" + port + "/pwd/{length}",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Password>>() {},
                24
        ).getBody();

        assertThat(response).isNotNull();
        assertThat(response.size()).isGreaterThan(0);
        assertThat(response.get(0).getPassword()).hasSize(24);
    }

    @Test
    void pwdCreated() {
        List<Password> response = restTemplate.exchange(
                "http://localhost:" + port + "/pwd/{length}",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Password>>() {},
                24
        ).getBody();

        assertThat(response).isNotNull();
        assertThat(response.get(0).getPassword()).isNotEmpty();
    }
}