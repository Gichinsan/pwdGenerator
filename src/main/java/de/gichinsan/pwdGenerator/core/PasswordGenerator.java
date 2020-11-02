package de.gichinsan.pwdGenerator.core;

public class PasswordGenerator {

    /**
     *
     */
    public PasswordGenerator() {
    }


    /**
     *
     * @param slFlag - smallLetters
     * @param scFlag - special characters
     * @param dFlag - digits
     * @param minlenght min length of the password
     * @return Password as String
     */
    public String passwordGenerator(int slFlag, int scFlag, int dFlag,
                                           int minlenght) {
        int iNumber;
        String simplePwd[] = {"A", "B", "C", "D", "E", "F", "G", "H", "I",
                "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U",
                "V", "W", "X", "Y", "Z"};
        String smallLetters[] = {"a", "b", "c", "d", "e", "f", "g", "h", "i",
                "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u",
                "v", "w", "x", "y", "z"};
        String specialCharacters[] = {"@", "#", "$", "%", "^", "&", "*", "~",
                "!", "?"};
        String digits[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String sPWD = "";
        for (int i = 0; i < minlenght; i++) {
            iNumber = (int) (Math.random() * ((25 - 1) + 1)) + 1;
            sPWD = sPWD + simplePwd[iNumber];

            if (slFlag == 1) {

                iNumber = (int) (Math.random() * ((25 - 1) + 1)) + 1;
                sPWD = sPWD + smallLetters[iNumber];
            }

            if (dFlag == 1) {

                iNumber = (int) (Math.random() * ((8 - 1) + 1)) + 1;
                sPWD = sPWD + digits[iNumber];
            }

            if (scFlag == 1) {

                iNumber = (int) (Math.random() * ((9 - 1) + 1)) + 1;
                sPWD = sPWD + specialCharacters[iNumber];
            }
        }
        sPWD = sPWD.substring(0, minlenght);
        return sPWD;
    }
}
