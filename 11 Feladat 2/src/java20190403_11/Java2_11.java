package java20190403_11;

/**
 *
 * @author t1
 */
public class Java2_11 {

    public static int[][] nepesseg
            = {
                {106, 107, 111, 133, 221, 767, 1766},
                {502, 635, 809, 947, 1402, 3634, 5268},
                {2, 2, 2, 6, 13, 30, 46},
                {163, 203, 276, 408, 547, 729, 628},
                {2, 7, 26, 82, 172, 307, 392},
                {16, 24, 38, 74, 167, 511, 809}
            };

    private static int nepessegIndex1 = nepesseg.length;
    private static int nepessegIndex2 = nepesseg[0].length;

    public static String[] foldreszek
            = {
                "Afrika",
                "Ázsia",
                "Ausztrália",
                "Európa",
                "Észak-America",
                "Dél-America"
            };
    public static int[] oszlop = {0, 0, 0, 0, 0, 0, 0};

    public static void main(String[] args) {
        String str;
        for (int ii = 0; ii < nepessegIndex1; ii++) {
            str = String.format("%20s", foldreszek[ii]);
            for (int jj = 0; jj < nepessegIndex2; jj++) {
                oszlop[jj] += nepesseg[ii][jj];
                str += String.format("%5d", nepesseg[ii][jj]);
            }
            System.out.println(str);
        }
        str = String.format("%20s", "Összeg");
        for (int jj = 0; jj < 7; jj++) {
            str += String.format("%5d", oszlop[jj]);
        }
        System.out.println(str);
    }
}
