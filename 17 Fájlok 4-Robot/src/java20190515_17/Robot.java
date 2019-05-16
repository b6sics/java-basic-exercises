package java20190515_17;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author b6dmin
 */
public class Robot {

    String[] utak;
    int db;

    void beolvas() {
        try (Scanner be = new Scanner(new File("src/txt/utak.txt"))) {
            db = be.nextInt();
            be.nextLine();
            utak = new String[db];
            for (int i = 0; i < db; i++) {
                utak[i] = be.nextLine();
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Robot.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    double tavolsag(String ut) {
        int x = 0, y = 0;
        for (int i = 0; i < ut.length(); i++) {
            switch (ut.charAt(i)) {
                case 'K':
                    x++;
                    break;
                case 'N':
                    x--;
                    break;
                case 'E':
                    y++;
                    break;
                case 'D':
                    y--;
                    break;
            }
        }
        return Math.sqrt(x * x + y * y);
    }

    int energia(String ut) {
        int e = 3;
        for (int i = 1; i < ut.length(); i++) {
            e++;
            if (ut.charAt(i) != ut.charAt(i - 1)) {
                e += 2;
            }
        }
        return e;
    }

    void kiir() {
        try (PrintWriter ki
                = new PrintWriter(new FileWriter("src/txt/kimenet.txt"))) {
            for (int i = 0; i < db; i++) {
                ki.println(utak[i]);
                ki.println("Távolság: " + tavolsag(utak[i]));
                ki.println("Energis: " + energia(utak[i]));
            }
        } catch (IOException ex) {
            Logger.getLogger(Robot.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) throws IOException {
        Robot r = new Robot();
        r.beolvas();
        r.kiir();
    }
}
