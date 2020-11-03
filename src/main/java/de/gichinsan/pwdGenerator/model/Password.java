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
