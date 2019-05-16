package java20190515_18;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author KjG
 */
public class Java20190515_18 {

    static int[][] szamok = new int[400][6];
    static int db = 0;
    static int[] stat = new int[46];

    static void feltolt(String s) {
        Scanner olvas = new Scanner(s);
        for (int i = 0; i < 6; i++) {
            szamok[db][i] = olvas.nextInt();

        }
    }

    static void statisztika() {
        // megszámlálás      
        for (int i = 0; i < db; i++) {
            for (int j = 0; j < 6; j++) {
                stat[szamok[i][j]]++;
            }
        }
        //listázás
        for (int i = 1; i < 46; i++) {
            System.out.print(stat[i] + " ");
            if (i % 10 == 0) {
                System.out.println("");
            }
        }
        System.out.println("");
    }

    static void legtobbszor() {
        int szam = 1;
        int max = stat[1];
        for (int i = 2; i < 46; i++) {
            if (stat[i] > max) {
                max = stat[i];
                szam = i;
            }
        }
        System.out.println("Legtöbbször húzott:" + szam);
    }

    static void legkevesebbszer() {
        int szam = 1;
        int min = stat[1];
        for (int i = 2; i < 46; i++) {
            if (stat[i] < min) {
                min = stat[i];
                szam = i;
            }
        }
        System.out.println("Legkevesebbszer húzott:" + szam);
    }

    public static void main(String[] args) throws IOException {
        File fbe = new File("src/txt/hatos.txt");
        Scanner be = new Scanner(fbe);
        while (be.hasNextLine()) {
            String sor = be.nextLine();
            feltolt(sor);
            db++;
        }
        be.close();
        statisztika();
        legtobbszor();
        legkevesebbszer();
    }
}
