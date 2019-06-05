package szavak;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author KjG
 */
public class Szavak {

    static char[] mh = {
        'a', 'á', 'e', 'é', 'i', 'í', 'o', 'ó', 'ö', 'ő', 'u', 'ú', 'ü', 'ű'
    };

    static int maganhangzok(String szo) {
        int o = 0;
        for (int ii = 0; ii < szo.length(); ii++) {
            char d = szo.charAt(ii);
            for (int jj = 0; jj < mh.length; jj++) {
                if (d == mh[jj]) {
                    o++;
                    break;
                }
            }
        }
        return o;
    }

    static String leghosszabb() throws IOException {
        String s = "";
        int kk = 0, sum = 0;
        Scanner be = new Scanner(new File("src/txt/szavak.txt"));
        while (be.hasNextLine()) {
            sum++;
            String dummy = be.nextLine();
            if (dummy.length() < 2 * maganhangzok(dummy)) {
                System.out.print(dummy);
                kk++;
                if (kk % 10 != 0) {
                    System.out.print(" ");
                } else {
                    System.out.println("");
                }
            }
            if (dummy.length() > s.length()) {
                s = dummy;
            }
        }
        System.out.println("\n\nEz az összes felsorolt szónak a");
//        DecimalFormat df = new DecimalFormat("#0.00");
//        System.out.println("A. " + kk + "/" + sum + " : "
//                + df.format(kk * 100.0 / sum) + " %-a");
        System.out.printf("\t%d/%d : %3.2f %%-a\n",
                kk, sum, (double) (100.0 * kk / sum));
        return s;
    }

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        Scanner be = new Scanner(System.in, "Cp1250");
        System.out.print("Kérek gépeljen be egy szót: ");
        String szo = be.nextLine();
        if (szo.equals("")) {
            szo = "megszentségteleníthetetlenségetekért";
        }
        System.out.println("A magánhangzók száma a '"
                + szo + "' szóban: " + maganhangzok(szo));
        System.out.println("\nA mássalhangzóknál több magánhangzót "
                + "tartalmazó szavak:");
        String lh = leghosszabb();
        System.out.println("\nA leghosszabb szó: " + lh
                + ", ami " + lh.length() + " betű hosszú");
    }
}
