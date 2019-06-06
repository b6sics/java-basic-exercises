package szinhaz;

/**
 *
 * @author b6dmin
 */
public class Szeksor {

    private String foglalt;
    private String kategoria;

    public Szeksor(String foglalt, String kategoria) {
        this.foglalt = foglalt;
        this.kategoria = kategoria;
    }

    /**
     * megadja, hogy szabd-e egy adott indexű szék a sorban
     *
     * @param szek - a vizsgált szék indexe
     * @return
     */
    public boolean szabad(int szek) {
        return foglalt.charAt(szek) == 'o';
    }

    /**
     * megadja, hány jegyet adtak el a sorba
     *
     * @return eladott jegyek száma
     */
    public int eladott() {
        int db = 0;
        for (int ii = 0; ii < foglalt.length(); ii++) {
            if (!szabad(ii)) {
                db++;
            }
        }
        return db;
    }

    /**
     * meghatározza, melyik kategóriájú jegyből hányat adtak el
     *
     * @param stat 5 elemű tömb, amelyben számolunk
     */
    public void arkategoria(int[] stat) {
        for (int ii = 0; ii < kategoria.length(); ii++) {
            if (!szabad(ii)) {
                stat[kategoria.charAt(ii) - '0' - 1]++;
            }
        }
    }

    /**
     * Megszámolja hány magányos hely van a sorban
     *
     * @return a magányos helyek száma
     */
    public int egyhely() {
        int db = 0;
        String f = "x" + foglalt + "x";
        for (int ii = 0; ii < f.length() - 2; ii++) {
            if (f.substring(ii, ii + 3).equals("xox")) {
                db++;
            }
        }
        return db;
    }

    public static void main(String[] args) {
        Szeksor sz1 = new Szeksor("xxoxoxoxoxoxooxxxxox", "22222111111111122222");

        System.out.println(sz1.szabad(0));
        System.out.println(sz1.szabad(2));
        System.out.println("eladott jegyek: " + sz1.eladott());

        int[] t = {0, 0, 0, 0, 0};
        sz1.arkategoria(t);
        System.out.println(t[0] + ", " + t[1] + ", "
                + t[2] + ", " + t[3] + ", " + t[4]);
    }
}
