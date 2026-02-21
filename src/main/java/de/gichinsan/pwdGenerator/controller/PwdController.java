/**
 * This file is part of PasswordGenerator.
 * <p>
 * PasswordGenerator is free software: you can redistribute it and/or modify it
 * under the terms of the GNU General Public License as published by the Free
 * Software Foundation, either version 3 of the License, or (at your option) any
 * later version.
 * <p>
 * PasswordGenerator is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * <p>
 * You should have received a copy of the GNU General Public License along with
 * PasswordGenerator. If not, see <http://www.gnu.org/licenses/>.
 *
 *
 */
package de.gichinsan.pwdGenerator.controller;

import de.gichinsan.pwdGenerator.model.Password;
import de.gichinsan.pwdGenerator.utils.PasswordGenerator;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class PwdController {

    /**
     *
     * @param count
     * @param sl
     * @param sc
     * @param dl
     * @param length
     * @return
     */
    @GetMapping("/pwd/{length}")
    public List<Password> getPassword(
            @RequestParam(defaultValue = "1") int count,
            @RequestParam(defaultValue = "1") int sl,
            @RequestParam(defaultValue = "0") int sc,
            @RequestParam(defaultValue = "0") int dl,
            @PathVariable int length) {

        List<Password> pwds = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            PasswordGenerator passwordGenerator = new PasswordGenerator();
            String pwdValue = passwordGenerator.passwordGenerator(sl, sc, dl, length);
            pwds.add(new Password(i, pwdValue));
        }

        return pwds;
    }
}