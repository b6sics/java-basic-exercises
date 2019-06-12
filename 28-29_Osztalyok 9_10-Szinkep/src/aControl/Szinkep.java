/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aControl;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author KjG
 */
public class Szinkep {

    static final int MERET = 50;
    static Keppont[][] kep = new Keppont[MERET + 1][MERET + 1];

    static void megjelenit() {
        int i, j;
        for (i = 1; i <= MERET; i++) {
            for (j = 1; j <= MERET; j++) {
                System.out.print(kep[i][j].szinjel());
            }
            System.out.println("");
        }
    }

    static void szerepel() {
        Scanner bill = new Scanner(System.in);
        System.out.println("Színkód (200 96 64): ");
        String kod = bill.nextLine();
        boolean van = false;
        for (int sor = 1; sor <= MERET; sor++) {
            for (int oszlop = 1; oszlop <= MERET; oszlop++) {
                if (kep[sor][oszlop].getSzin().equals(kod)) {
                    van = true;
                    break;
                }
            }
            if (van) {
                break;
            }
        }
        if (van) {
            System.out.println("Van ilyen színű pont.");
        } else {
            System.out.println("Nincs ilyen színű pont.");
        }
    }

    static void keres(int x, int y) {
        String kod = kep[x][y].getSzin();
        int dbs = 0;
        for (int oszlop = 1; oszlop <= MERET; oszlop++) {
            if (kep[x][oszlop].getSzin().equals(kod)) {
                dbs++;
            }
        }
        int dbo = 0;
        for (int sor = 1; sor <= MERET; sor++) {
            if (kep[sor][y].getSzin().equals(kod)) {
                dbo++;
            }
        }
        System.out.println(kod + " sorban: " + dbs
                + " oszlopban: " + dbo);
    }

    static void vzk() {
        int vdb = 0;
        int zdb = 0;
        int kdb = 0;
        String kod;
        for (int sor = 1; sor <= MERET; sor++) {
            for (int oszlop = 1; oszlop <= MERET; oszlop++) {
                kod = kep[sor][oszlop].getSzin();
                if (kod.equals("255 0 0")) {
                    vdb++;
                } else if (kod.equals("0 255 0")) {
                    zdb++;
                } else if (kod.equals("0 0 255")) {
                    kdb++;
                }
            }
        }
        System.out.println("A legtöbbször előforduló szín: ");
        int max = vdb;
        String szin = "vörös";
        if (zdb > max) {
            max = zdb;
            szin = "zöld";
        }
        if (kdb > max) {
            max = kdb;
            szin = "kék";
        }
        System.out.println(szin + " " + max);
    }

    static void keret() {
        for (int sor = 1; sor <= MERET; sor++) {
            for (int oszlop = 1; oszlop <= MERET; oszlop++) {
                if (sor < 4 || sor > 47
                        || oszlop < 4 || oszlop > 47) {
                    kep[sor][oszlop].setSzin("0 0 0");
                }
            }
        }
        megjelenit();
    }

    static void kiir(String target) throws IOException {
        PrintWriter ki = new PrintWriter(target);
        for (int sor = 1; sor <= MERET; sor++) {
            for (int oszlop = 1; oszlop <= MERET; oszlop++) {
                ki.print(kep[sor][oszlop].szinjel());
            }
            ki.println("");
        }
        ki.close();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Scanner be = new Scanner(new File("src/aData/kep.txt"));
        int sor, oszlop;
        for (sor = 1; sor <= MERET; sor++) {
            for (oszlop = 1; oszlop <= MERET; oszlop++) {
                kep[sor][oszlop] = new Keppont(be.nextLine());
            }
        }
        be.close();
        megjelenit();
        szerepel();
        keres(35, 8);
        vzk();
        keret();
        kiir("src/aData/keretes.txt");
    }
}
