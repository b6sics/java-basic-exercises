package dolgozat2_kjg;

import java.util.Scanner;

/**
 *
 * @author t1
 */
public class Dolgozat2_KjG {

    private static final Scanner SC = new Scanner(System.in, ("Cp1250"));

    private static int a, b, c;

    private static int[] t;

    public static void main(String[] args) {
        System.out.println("Kérek három egész számot");
        System.out.print("az első szám (a tömb mérete): ");
        a = SC.nextInt();
        System.out.print("a második szám (a legkisebb lehetséges érték): ");
        b = SC.nextInt();
        System.out.print("a harmadik szám (a legnagyobb lehetséges érték): ");
        c = SC.nextInt();

        if (b > c) {
            int dummy = b;
            b = c;
            c = dummy;
        }

        t = new int[a];

        for (int i = 0; i < a; i++) {
            t[i] = (int) (Math.random() * (c - b + 1) + b);
            System.out.print(t[i] + " ");
        }
        System.out.println("\t");
        int max = t[0];
        System.out.print("A tömb legnagyobb értéke: ");
        for (int i = 1; i < t.length; i++) {
            if (max < t[i]) {
                max = t[i];
            }
        }
        System.out.println(max + ".");
        int min = t[0];
        System.out.print("A tömb legkisebb értéke: ");
        for (int i = 1; i < t.length; i++) {
            if (min > t[i]) {
                min = t[i];
            }
        }
        System.out.println(min + ".");
    }

}
