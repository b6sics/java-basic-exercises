package java2_arrays;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author KjG
 */
public class Java2_Arrays {

    public static Scanner sc = new Scanner(System.in, ("Cp1250"));
    private static int feb[] = {2, 1, 5, -3, 3, 2, 8, -5, 1, 2, 2, -5, 0, 5,
        -3, 5, -3, 3, -21, 1, -9, -2, 1, 1, -9, -12, 0, -5};

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

    private static double atlag() {
        int sum = 0;
        for (int elem : feb) {
            sum += elem;
        }
        return (double) sum / feb.length;
    }

    private static int minimum() {
        int min = feb[0];
        for (int ii = 1; ii < feb.length; ii++) {
            if (feb[ii] < min) {
                min = feb[ii];
            }
        }
        return min;
    }

    private static int maximum() {
        int max = feb[0];
        for (int ii = 1; ii < feb.length; ii++) {
            if (feb[ii] > max) {
                max = feb[ii];
            }
        }
        return max;
    }

    private static int keres(int mit) {
        for (int ii = 0; ii < feb.length; ii++) {
            if (mit == feb[ii]) {
                return ii;
            }
        }
        return -1;
    }

    private static int fagy() {
        int sum = 0;
        for (int elem : feb) {
            if (elem <= 0) {
                sum++;
            }
        }
        return sum;
    }

    private static void javit() {
        System.out.print("Mennyit változtassak? ");
        int mennyit = sc.nextInt();
        sc.nextLine();
        for (int ii = 0; ii < feb.length; ii++) {
            feb[ii] += mennyit;
        }
    }

    private static void diagram() {
        int min = minimum();
        for (int elem : feb) {
            for (int ii = min; ii < elem; ii++) {
                System.out.print("*");
            }
            System.out.println("");
        }
    }

    private static void f1(String label) {
        f00(60, '-', label);
        char v;
        int x;
        boolean kilep = false;
        do {
            System.out.println("1-Átlag 2-Min 3-Max 4-Fagy 5-Javít 6-Diagram 0-Kilép");
            System.out.print("Választás: ");
            v = sc.nextLine().charAt(0);
            switch (v) {
                case '1':
                    System.out.println("Átlag: " + atlag());
                    break;
                case '2':
                    x = minimum();
                    System.out.println("Minimum: " + x);
                    System.out.println("A leghidegebb nap: " + (keres(x) + 1));
                    break;
                case '3':
                    x = maximum();
                    System.out.println("Maximum: " + x);
                    System.out.println("A legmelegebb nap: " + (keres(x) + 1));
                    break;
                case '4':
                    System.out.println("Fagyos napok: " + fagy());
                    break;
                case '5':
                    javit();
                    System.out.println("Javítás kész.");
                    break;
                case '6':
                    System.out.println("Diagram: ");
                    diagram();
                    break;
                default:
                    kilep = true;
                    break;
            }
        } while (!kilep);
        System.out.println("");
    }

    private static void f2(String label, int n, int x) {
        f00(60, '-', label);

        System.out.print("\n");
    }

    private static void f3(String label, int szam) {
        f00(60, '-', label);

        System.out.println("");
    }

    private static void f4(String label) {
        f00(60, '-', label);

        System.out.println("");
    }

    public static void main(String[] args) {
        f00(60, '*', "STARTofJAVA 2019mar20 Arrays B");
        f00(60, '-', "");

        f1("Tömbök 4-5. Februári statisztikák");

        f00(60, '-', "");
        f00(60, '*', "ENDofJAVA   2019mar20");
    }

}
