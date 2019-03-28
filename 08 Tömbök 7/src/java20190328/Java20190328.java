package java20190328;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author KissJGabi
 */
public class Java20190328 {

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

    private static int[] pontok = new int[10];
    private static int db = 0;

    private static void f1(String label) {
        Scanner sc = new Scanner(System.in, ("Cp1250"));
        f00(60, '-', label);
        System.out.println("Pontok: ");
        while (sc.hasNextInt()) {
            pontok[db++] = sc.nextInt();
            if (db == 10) {
                break;
            }
        }
        sc.nextLine();
        int[] masolat = Arrays.copyOf(pontok, db);
        System.out.println(Arrays.toString(masolat));
        Arrays.sort(masolat);
        int osszeg = 0;
        for (int ii = 1; ii < masolat.length; ii++) {
            osszeg += masolat[ii];
        }
        System.out.println("A pontszám: " + osszeg);
        System.out.println("");
    }

    private static Integer[] pont = new Integer[10];

    private static void f2(String label) {
        Scanner sc = new Scanner(System.in, ("Cp1250"));
        f00(60, '-', label);
        db = 0;
        System.out.println("Pontok: ");
        while (sc.hasNextInt()) {
            pont[db++] = sc.nextInt();
            if (db == 10) {
                break;
            }
        }
        sc.nextLine();
        Integer[] masolat = Arrays.copyOf(pont, db);
        System.out.println(Arrays.toString(masolat));
        Arrays.sort(masolat, Collections.reverseOrder());
        int osszeg = 0;
        for (int ii = 0; ii < masolat.length - 1; ii++) {
            osszeg += masolat[ii];
        }
        System.out.println("A pontszám: " + osszeg);
        System.out.println("");
    }

    public static void main(String[] args) {
        f00(60, '*', "STARTofJAVA 2019mar28 Arrays");
        f00(60, '-', "");

        f1("Tömbök 7a. Vetélkedő");
        f2("Tömbök 7b. Vetélkedő (Wrapper)");

        f00(60, '-', "");
        f00(60, '*', "ENDofJAVA   2019mar28");
    }

}
