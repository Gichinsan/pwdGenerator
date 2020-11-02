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
