/**
 * This file is part of PasswordGenerator.
 *
 * PasswordGenerator is free software: you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or (at your option) any
 * later version.
 *
 * PasswordGenerator is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * PasswordGenerator. If not, see <http://www.gnu.org/licenses/>.
 *
 *
 */
package de.gichinsan.pwdGenerator;

import de.gichinsan.pwdGenerator.controller.PwdController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PwdGeneratorApplicationTests {

    @LocalServerPort
    private int port;

    @Autowired
    PwdController controller;

    @Autowired
    private TestRestTemplate restTemplate;


    @Test
    void contextLoads() {
        assertThat(controller).isNotNull();
    }

    @Test
    public void pwdCreatedSize() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/pwd/24",
                String.class)).hasSize(64);
    }

    @Test
    public void pwdCreated() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/pwd/24",
                String.class)).contains("password");
    }


}
