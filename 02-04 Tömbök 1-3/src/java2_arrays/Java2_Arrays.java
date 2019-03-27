package java2_arrays;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author KjG
 */
public class Java2_Arrays {

    public static Scanner sc = new Scanner(System.in, ("Cp1250"));

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

    private static void f1(String label, int n, int x) {
        f00(60, '-', label);
        Random vg = new Random();
        int d;
        int[] dobas = new int[n + 1];
        for (int ii = 0; ii < x; ii++) {
            d = vg.nextInt(n) + 1;
            dobas[d]++;
        }
        for (int ii = 1; ii <= n; ii++) {
            System.out.println("\t" + ii + ": " + dobas[ii]);
        }
        System.out.println("");
    }

    private static void f2(String label, int n, int x) {
        f00(60, '-', label);
        Random vg = new Random();
        boolean szelveny[] = new boolean[n + 1];
        int szam;
        int db = 0;
        while (db < x) {
            szam = vg.nextInt(n) + 1;
            if (!szelveny[szam]) {
                szelveny[szam] = true;
                db++;
            }
        }
        System.out.print("A számok: ");
        for (int ii = 1; ii < szelveny.length; ii++) {
            if (szelveny[ii]) {
                System.out.print(ii + " ");
            }
        }
        System.out.print("\n");
    }

    private static void f3(String label, int szam) {
        f00(60, '-', label);
        String[] egyesek = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String[] tizesek = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] szazasok = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] ezresek = {"", "M", "MM", "MMM"};
        String romai;
        boolean stop = true;
        while (stop) {
            System.out.print("Az átváltandó szám: ");
            if (szam == 0) {
                szam = sc.nextInt();
            } else {
                System.out.println(szam + ".");
                stop = false;
            }
            if (szam < 1 || szam > 3999) {
                break;
            }
            romai = ezresek[szam / 1000];
            szam %= 1000;
            romai += szazasok[szam / 100];
            szam %= 100;
            romai += tizesek[szam / 10];
            szam %= 10;
            romai += egyesek[szam];
            System.out.println("Római számmal: " + romai);
        }
        System.out.println("");
    }

    private static int[] sor = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    private static void kiir() {
        for (int ii = 0; ii < sor.length; ii++) {
            System.out.print(sor[ii] + " ");
        }
        System.out.println("");
    }

    private static void megfordit(int n) {
        int x;
        for (int ii = 0; ii < n / 2; ii++) {
            x = sor[ii];
            sor[ii] = sor[n - ii - 1];
            sor[n - ii - 1] = x;
        }
    }

    private static void kever(int hanyszor) {
        Random vg = new Random();
        int db;
        for (int ii = 0; ii < hanyszor; ii++) {
            db = vg.nextInt(8) + 2;
            megfordit(db);
        }
    }

    private static boolean kesz() {
        for (int ii = 0; ii < 9; ii++) {
            if (sor[ii] != ii + 1) {
                return false;
            }
        }
        return true;
    }

    private static int beolvas() {
        int be;
        do {
            System.out.print("Hányat fordítsak meg? ");
            be = sc.nextInt();
        } while (be < 2 || be > 9);
        return be;
    }

    private static void f4(String label) {
        f00(60, '-', label);
        int lepes;
        do {
            System.out.println("Rendezd növekvő sorrendbe a számokat!");
            kever(50);
            kiir();
            lepes = 0;
            while (!kesz()) {
                megfordit(beolvas());
                kiir();
                lepes++;
            }
            System.out.print("Gratulálok, megoldottad ");
            System.out.print(lepes);
            System.out.println(" lépésben!");
            System.out.println("Még egy játék? (i/n): ");
            sc.nextLine();
        } while (sc.nextLine().toUpperCase().charAt(0) != 'N');
        System.out.println("");
    }

    public static void main(String[] args) {
        f00(60, '*', "STARTofJAVA 2019mar20 Arrays");
        f00(60, '-', "");

        f1("Tömbök 1. Kockadobás statisztika", 6, 10000);
        f2("Tömbök 2a. Lottó 5", 90, 5);
        f3("Tömbök 2b. Római számok", 1965);
        f3("Tömbök 2b. Római számok", 1848);
        f4("Tömbök 3. Fordítós játék");

        f00(60, '-', "");
        f00(60, '*', "ENDofJAVA   2019mar20");
    }

}
