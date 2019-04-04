package arrays8;

import java.util.*;

/**
 *
 * @author KjG
 */
public class Arrays_8 {

    Random rnd = new Random();
    int[][] dobasok = new int[7][7];
    int sor, oszlop;

    private void start(int n) {
        for (int ii = 0; ii < n; ii++) {
            sor = rnd.nextInt(6) + 1;
            oszlop = rnd.nextInt(6) + 1;
            dobasok[sor][oszlop]++;
        }
        for (int ii = 1; ii < 7; ii++) {
            for (int jj = 1; jj < 7; jj++) {
                System.out.print(dobasok[ii][jj] + " ");
            }
            System.out.println("");
        }

        int hetesek = dobasok[1][6]
                + dobasok[6][1]
                + dobasok[2][5]
                + dobasok[5][2]
                + dobasok[3][4]
                + dobasok[4][3];
        System.out.println("Hetesek: " + hetesek);

        int tizenegyesek = dobasok[5][6] + dobasok[6][5];
        System.out.println("Tizenegyesek: " + tizenegyesek);
    }

    public static void main(String[] args) {
        new Arrays_8().start(1000);
    }
}
