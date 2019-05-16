package java20190515_16;

/**
 *
 * @author KjG
 */
public class Caesar {

    public Caesar() {

    }

    String titkosit(String s, int tol) {
        s = s.toUpperCase().replace(" ", "");
        s = s.replace("Á", "A").replace("É", "E").replace("Í", "I");
        s = s.replaceAll("[ÓÖŐ]", "O").replaceAll("[ÚÜŰ]", "U");
        String uj = "";
        int hossz = 'Z' - 'A' + 1;
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) + tol;
            if (c < 'A') {
                c += hossz;
            } else if (c > 'Z') {
                c -= hossz;
            }
            uj += (char) c;
        }
        return uj;
    }
}
