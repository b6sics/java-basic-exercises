package kektura;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author KjG
 */
public class Kektura {

    static ArrayList<Szakasz> szakaszok = new ArrayList<>();
    private static int magassag;

    /**
     * Kiszámolja a szakaszok teljes hosszát
     */
    private static void f1() {
        double hossz = 0;
        for (Szakasz sz : szakaszok) {
            hossz += sz.getTav();
        }
        System.out.printf("A túra teljes hossza: %.3f km\n", hossz);
    }

    /**
     * A leghosszabb szakaszok
     */
    private static void f2() {
        ArrayList<Szakasz> masolat = new ArrayList<>(szakaszok);
        Collections.sort(masolat,
                (a, b) -> Double.compare(b.getTav(), a.getTav()));
        System.out.println("A leghosszabb szakaszok:");
        for (int ii = 0; ii < 3; ii++) {
            System.out.println(masolat.get(ii));
        }
        System.out.println("A legrövidebb szakasz:");
        System.out.println(masolat.get(masolat.size() - 1));
    }

    /**
     * A legmagasabb pont helye és magassága
     */
    private static void f3() {
        int vpmagassag = magassag, legmagasabb = magassag;
        int hol = -1;
        for (int ii = 0; ii < szakaszok.size(); ii++) {
            vpmagassag += szakaszok.get(ii).szintvaltozas();
            if (vpmagassag > legmagasabb) {
                legmagasabb = vpmagassag;
                hol = ii;
            }
        }
        System.out.println("A Legmagasabb végpont: " + legmagasabb + " m");
        System.out.println(szakaszok.get(hol));
    }

    /**
     * Hiányos állomásnevek
     */
    private static void f4() {
        int db = 0;
        System.out.println("Hiányos állomásnevek:");
        for (Szakasz sz : szakaszok) {
            if (sz.hianyos()) {
                System.out.println(sz);
                db++;
            }
        }
        if (db == 0) {
            System.out.println("Nincs hiányos állomásnév!");
        }
    }

    private static void f5() throws IOException {
        PrintWriter ki = new PrintWriter("src/csv/kektura2.csv");
        ki.println(magassag);
        for (Szakasz sz : szakaszok) {
            sz.javit();
            ki.println(sz);
        }
        ki.close();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // beolvasás
        Scanner be = new Scanner(new File("src/csv/kektura.csv"));
        magassag = Integer.parseInt(be.nextLine());
        while (be.hasNextLine()) {
            szakaszok.add(new Szakasz(be.nextLine()));
        }
        be.close();
        System.out.println("A szakaszok száma: " + szakaszok.size());
        f1();
        f2();
        f3();
        f4();
        f5();
    }
}
