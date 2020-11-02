package de.gichinsan.pwdGenerator.model;

import lombok.Data;

@Data
public class Password {

    private int id;
    private String password;


    public Password(int i, String passwordGenerator) {
        this.id = i;
        this.password = passwordGenerator;
    }
}
