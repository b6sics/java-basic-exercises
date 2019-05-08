package toldi;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author t1
 */
public class Toldi {

    private static int f(String label, String fájl, String cp) {
        int sorok = 0;
        try (Scanner be = new Scanner(new File(fájl), cp)) {
            while (be.hasNextLine()) {
                String sor = be.nextLine();
                System.out.println(sor);
                sorok++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Nincs meg a fájl!");
            return -1;
        }
        System.out.print(label);
        return sorok;
    }

    public static void main(String[] args) {
        String str = "\n1. A vers1.txt sorainak a száma: ";
        System.out.println(f(str, "vers1.txt", "Cp1250"));
        System.out.println("A szöveg nem Cp1250-es kódolású.");
        System.out.println("---------------------------------------------\n");
        str = "\n2. A vers2.txt sorainak a száma: ";
        System.out.println(f(str, "vers2.txt", "Cp1250"));
        System.out.println("--------------------------------------------\n");
        str = "3. vers3.txt nem létezik -> a sorok száma: ";
        System.out.println(str + f("", "vers3.txt", "Cp1250"));
        System.out.println("---------------------------------------------\n");
    }

}
