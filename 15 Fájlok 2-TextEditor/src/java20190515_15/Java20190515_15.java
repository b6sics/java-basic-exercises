package java20190515_15;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author KjG
 */
public class Java20190515_15 {

    public static void main(String[] args) throws IOException {
        Scanner bill = new Scanner(System.in, "Cp1250");
        System.out.print("A fájl neve: ");
        String nev = bill.nextLine();

        FileWriter f = new FileWriter("src/txt/" + nev + ".txt", true);
        PrintWriter p = new PrintWriter(f);

        System.out.println("Írd be a sorokat! Vége: *");
        while (true) {
            String sor = bill.nextLine();
            if (sor.equals("*")) {
                System.out.println(sor);
                break;
            }
            p.println(sor);
        }
        p.close();
        try (Scanner be = new Scanner(new File("src/txt/" + nev + ".txt"), "Cp1250")) {
            while (be.hasNextLine()) {
                String sor = be.nextLine();
                System.out.println(sor);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Nincs meg a fájl!");
        }

    }

}
