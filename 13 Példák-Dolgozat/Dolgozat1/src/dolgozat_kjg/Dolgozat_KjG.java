package dolgozat_kjg;

import java.util.Scanner;

/**
 *
 * @author t1
 */
public class Dolgozat_KjG {

    private static final String CHAR_SET_SCANNER = "Cp1250";
    private static final KeyBoardIO KB = new KeyBoardIO(CHAR_SET_SCANNER);

    private static int a, b;

    private static final String YES_NO = "in";

    private static void f01() {
        System.out.println("1. feladat");
        a = (int) (Math.random() * (49 - 10 + 1) + 10);
        System.out.println("Az első szám: " + a);
        do {
            b = KB.getInt("A második szám (" + (a + 10) + " - 149) között: ");
            if (!(b >= (a + 10) && b < 150)) {
                System.out.println("\thibás értéket adtál meg!");
            }
        } while (!(b >= (a + 10) && b < 150));
        System.out.println("\n\nA feladat: egyesével");
        for (int i = a; i <= b; i++) {
            System.out.print(i + " ");;
        }
        System.out.println("\n\nB feladat: hármasával");
        for (int i = a; i <= b; i++) {
            if (i % 3 == 0) {
                System.out.println(i);
            }
        }
        System.out.println("");
    }

    private static void f02() {
        System.out.println("2. feladat:\n");
        a = (int) (Math.random() * (100 - 1 + 1) + 1);
        int step, input;
        boolean ok;
        String yesORno;
        do {
            System.out.println("Gondoltam egy számot egy és száz között!\n"
                    + "\tTaláld ki maximum 10 lépésben");
            yesORno = "";
            step = 0;
            input = 0;
            ok = false;
            do {
                input = KB.getInt("tippelj!");
                if (a == input) {
                    ok = true;
                } else if (a > input) {
                    System.out.println("Ennél nagyobbra gondoltam!");
                } else {
                    System.out.println("Ennél kisebbre gondoltam!");
                }
                step++;
            } while (!ok && step < 10);
            if (ok) {
                System.out.println("Gratulálok, kitaláltad a számot " + step
                        + " lépésben.");
            } else {
                System.out.println("Sajnálom, nem találtad ki a számot " + step
                        + " lépésben.");
            }
        } while (!KB.getChar("Még egy játé? (i/n) ", YES_NO));
        System.out.println("");
    }

    private static void f03() {
        System.out.println("3. feladat:\n");
        int n = KB.getInt("Hány példát generáljak?");
        int result;
        for (int ii = 1; ii <= n; ii++) {
            System.out.println(ii + ". példa:");
            a = (int) (Math.random() * (100 - 1 + 1) + 1);
            do {
                b = (int) (Math.random() * (100 - 1 + 1) + 1);
            } while (a == b);
            result = KB.getInt(a + " + " + b + " = ");
            if (result != a + b) {
                System.out.println("Hbásan számoltál!");
            } else {
                System.out.println("Jól számoltál!");
            }
            result = KB.getInt(a + " - " + b + " = ");
            if (result != a - b) {
                System.out.println("Hbásan számoltál!");
            } else {
                System.out.println("Jól számoltál!\n");
            }
        }

        System.out.println("");
    }

    public static void main(String[] args) {
        f01();
        f02();
        f03();
    }
}
