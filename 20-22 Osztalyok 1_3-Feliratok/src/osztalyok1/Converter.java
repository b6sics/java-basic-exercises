package osztalyok1;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * szöveges fájl átalakítása srt formátumra
 *
 * @author KjG
 */
public class Converter {

    static ArrayList<Felirat> feliratok = new ArrayList<>();

    /**
     *
     * @param args
     */
    public static void main(String[] args) throws IOException {
        Scanner be = new Scanner(new File("src/txt/feliratok.txt"));
        String s1, s2;
        while (be.hasNextLine()) {
            s1 = be.nextLine();
            s2 = be.nextLine();
            feliratok.add(new Felirat(s1, s2));
        }
        System.out.println("Feliratok száma: "
                + feliratok.size());
        be.close();
        int max = 0;
        String m = "";

        PrintWriter ki = new PrintWriter("src/txt/felirat.srt");
        for (int i = 0; i < feliratok.size(); i++) {
            ki.println(i + 1);
            feliratok.get(i).eltol(1);
            if (max < feliratok.get(i).getSZOVEG().length()) {
                m = feliratok.get(i).getSZOVEG();
                max = m.length();
            }
            ki.println(feliratok.get(i).getSrt());
            ki.println(feliratok.get(i).getSZOVEG());
            ki.println();
        }
        ki.close();
        System.out.println("A leghosszabb szöveg: ");
        System.out.println("\"" + m + "\", ");
        System.out.println("ami " + max + " betűből áll.");
    }
}
