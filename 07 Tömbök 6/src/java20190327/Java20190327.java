package java20190327;

import java.util.Random;

/**
 *
 * @author KjG
 */
public class Java20190327 {

    private static int[] szamok = new int[10];

    private static void f00(int hossz, char jel, String name) {
        int start = 0;
        if (name.length() != 0) {
            start = name.length() + 5;
            System.out.print(jel + "| ");
            System.out.print(name + " |");
        }
        for (int ii = start; ii < hossz; ii++) {
            System.out.print(jel);
        }
        System.out.println("");
    }

    private static void feltolt() {
        Random vg = new Random();
        for (int ii = 0; ii < szamok.length; ii++) {
            szamok[ii] = vg.nextInt(100);
        }
    }

    private static void kiir() {
        for (int ii = 0; ii < szamok.length; ii++) {
            System.out.print(szamok[ii] + " ");
        }
        System.out.println("");
    }

    private static void csere(int n) {
        int dummy = szamok[n];
        szamok[n] = szamok[n + 1];
        szamok[n + 1] = dummy;
    }

    private static void rendez_fel() {
        for (int ii = szamok.length - 1; ii > 0; ii--) {
            for (int jj = 0; jj < ii; jj++) {
                if (szamok[jj] > szamok[jj + 1]) {
                    csere(jj);
                }
            }
        }
    }

    private static void rendez_le() {
        for (int ii = szamok.length - 1; ii > 0; ii--) {
            for (int jj = 0; jj < ii; jj++) {
                if (szamok[jj] < szamok[jj + 1]) {
                    csere(jj);
                }
            }
        }
    }

    private static void f1(String label) {
        f00(60, '-', label);
        feltolt();
        kiir();
        rendez_fel();
        kiir();
        rendez_le();
        kiir();
        System.out.println("");
    }

    private static String[] b = {"Merkúr", "Vénusz", "Föld", "Mars",
        "Jupiter", "Szaturnusz", "Uranus", "Neptunusz"};

    private static void b_kiir() {
        for (int ii = 0; ii < b.length; ii++) {
            System.out.print(b[ii] + " ");
        }
        System.out.println("");
    }

    private static void b_csere(int n) {
        String dummy = b[n];
        b[n] = b[n + 1];
        b[n + 1] = dummy;
    }

    private static void b_rendez_fel() {
        for (int ii = b.length - 1; ii > 0; ii--) {
            for (int jj = 0; jj < ii; jj++) {
                if (b[jj].compareTo(b[jj + 1]) > 0) {
                    b_csere(jj);
                }
            }
        }
    }

    private static void b_rendez_le() {
        for (int ii = b.length - 1; ii > 0; ii--) {
            for (int jj = 0; jj < ii; jj++) {
                if (b[jj].compareTo(b[jj + 1]) < 0) {
                    b_csere(jj);
                }
            }
        }
    }

    private static void b_rendez_l() {
        for (int ii = b.length - 1; ii > 0; ii--) {
            for (int jj = 0; jj < ii; jj++) {
                if (b[jj].length() > b[jj + 1].length()) {
                    b_csere(jj);
                }
            }
        }
    }

    private static void f2(String label) {
        f00(60, '-', label);
        b_kiir();
        b_rendez_fel();
        b_kiir();
        b_rendez_le();
        b_kiir();
        b_rendez_l();
        b_kiir();
        System.out.println("");
    }

    public static void main(String[] args) {
        f00(60, '*', "STARTofJAVA 2019mar20 Arrays");
        f00(60, '-', "");

        f1("Tömbök 6a. Buborékos rendezés");
        f2("Tömbök 6b. Bolygók");

        f00(60, '-', "");
        f00(60, '*', "ENDofJAVA   2019mar20");

    }

}
