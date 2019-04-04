package java2_13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author KjG
 */
public class Lista2 {

    public static ArrayList<Integer> utalasok = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "Cp1250");
        System.out.print("Utalások: ");
        while (sc.hasNextInt()) {
            utalasok.add(sc.nextInt());
        }
        int sum = 0;
        for (int i = 0; i < utalasok.size(); i++) {
            sum += utalasok.get(i);
        }
        System.out.println("A befolyt összeg: " + sum);
        Collections.sort(utalasok, Collections.reverseOrder());
        System.out.println(utalasok);

        if (utalasok.size() > 3) {
            ArrayList<Integer> copy = new ArrayList<>(utalasok.subList(0, 3));
            System.out.println("A legnagyobbak: " + copy);

            System.out.println("A legkisebb adomány: "
                    + utalasok.get(utalasok.size() - 1));

            System.out.printf("Átlag A: %7.2f \n\n", ((double) sum / (utalasok.size())));
        }
    }
}
