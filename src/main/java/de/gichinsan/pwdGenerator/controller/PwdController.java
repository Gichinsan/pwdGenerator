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
package de.gichinsan.pwdGenerator.controller;

import de.gichinsan.pwdGenerator.core.PasswordGenerator;
import de.gichinsan.pwdGenerator.model.Password;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PwdController {

    @RequestMapping(path = "/")
    public String index() {
        return "index";
    }

    /**
     * @param count  - number of entities
     * @param sl     - with small characters
     * @param sc     - with special characters
     * @param dl     - digitnumbers
     * @param length - length of the password
     * @return list of password as JSON
     */
    @GetMapping(value = "/pwd/{length}", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public List<Password> getPassword(@RequestParam(defaultValue = "1", name = "count") int count, @RequestParam(defaultValue = "1", name = "sl") int sl, @RequestParam(defaultValue = "0", name = "sc") int sc, @RequestParam(defaultValue = "0", name = "dl") int dl, @PathVariable int length) {
        List<Password> pwds = new ArrayList<Password>();
        PasswordGenerator pwd = new PasswordGenerator();

        for (int i = 0; i < count; i++) {
            String pwdvalue = pwd.passwordGenerator(sl, sc, dl, length);
            pwds.add(new Password(i, pwdvalue));
        }

        return pwds;
    }


}
