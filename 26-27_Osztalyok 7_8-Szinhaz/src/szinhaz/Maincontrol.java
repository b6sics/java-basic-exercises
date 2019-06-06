package szinhaz;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * 2014. októberi emelt szintű érettségi feladat
 *
 * @author KjG
 */
public class Maincontrol {

    static final int MERET = 15;
    static Szeksor[] nezoter = new Szeksor[MERET];
    static int[] kat = {0, 0, 0, 0, 0};
    static int[] ar = {5000, 4000, 3000, 2000, 1500};

    /**
     * adatok beolvasása
     *
     * @param f1 - adatfájl1
     * @param f2 - adatfájl2
     * @throws IOException
     */
    private static void beolvas(String f1, String f2) throws IOException {
        Scanner be1 = new Scanner(new File(f1));
        Scanner be2 = new Scanner(new File(f2));
        for (int ii = 0; ii < MERET; ii++) {
            nezoter[ii] = new Szeksor(be1.nextLine(), be2.nextLine());
        }
        be1.close();
        be2.close();
    }

    private static void lekerdez() {
        Scanner bill = new Scanner(System.in, "Cp1250");
        System.out.print("A sor és a szék száma: ");
        int sor = bill.nextInt() - 1;
        int szek = bill.nextInt() - 1;
        if (nezoter[sor].szabad(szek)) {
            System.out.println("szabad");
        } else {
            System.out.println("foglalt");
        }
    }

    private static void eladottJegyek() {
        int db = 0;
        for (Szeksor szeksor : nezoter) {
            db += szeksor.eladott();
        }
        System.out.println("Az eladott jegyek száma: " + db);
    }

    private static int legtobb() {
        int legtobb = kat[0];
        int toReturn = 0;
        for (int ii = 0; ii < kat.length; ii++) {
            if (kat[ii] > toReturn) {
                legtobb = kat[ii];
                toReturn = ii;
            }
        }
        return toReturn;
    }

    private static int bevetel() {
        int bevetel = 0;
        for (int ii = 0; ii < ar.length; ii++) {
            bevetel += kat[ii] * ar[ii];
        }
        return bevetel;
    }

    private static int egyesHelyek() {
        int edb = 0;
        for (Szeksor sz : nezoter) {
            edb += sz.egyhely();
            System.out.println(edb);
        }
        return edb;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        beolvas("src/txt/foglaltsag.txt", "src/txt/kategoria.txt");
        lekerdez();
        eladottJegyek();
        for (Szeksor szeksor : nezoter) {
            szeksor.arkategoria(kat);
        }
        System.out.println("A legtöbb eladás a(z) " + (legtobb() + 1)
                + ". kategóriában volt.");
        System.out.println("A teljes bevétel: " + bevetel() + " Ft");
        System.out.println("Magányos helyek száma: " + egyesHelyek() + " db");
    }
}
