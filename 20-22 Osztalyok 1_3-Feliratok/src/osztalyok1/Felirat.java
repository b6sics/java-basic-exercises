package osztalyok1;

/**
 * Feliratok átalakítása srt formátumra
 *
 * @author KjG
 */
public class Felirat {

    private int ido1;
    private int ido2;
    private final String SZOVEG;

    /**
     * start időpont
     *
     * @return start time
     */
    public int getIDO1() {
        return ido1;
    }

    /**
     * vége időpont
     *
     * @return end time
     */
    public int getIDO2() {
        return ido2;
    }

    /**
     * szöveg lekérdezése
     *
     * @return subtitle row
     */
    public String getSZOVEG() {
        return SZOVEG;
    }

    /**
     * Felirat osztály konstruktora
     *
     * @param s1 első sor
     * @param s2 második sor
     */
    public Felirat(String s1, String s2) {
        this.ido1 = 60 * Integer.parseInt(s1.substring(0, 2))
                + Integer.parseInt(s1.substring(3, 5));
        this.ido2 = 60 * Integer.parseInt(s1.substring(8, 10))
                + Integer.parseInt(s1.substring(11, 13));
        this.SZOVEG = s2;
    }

    /**
     * egy időpont átalakítása másodpercről óó:pp:mp-re
     *
     * @param mp az időpont másodpercben
     * @return az óó:pp:mp formátomú string
     */
    private String atalakit(int mp) {
        return String.format("%02d:%02d:%02d",
                mp / 3600, (mp % 3600) / 60, mp % 60);
    }

    /**
     *
     * @return a megfelelő formátomú string
     */
    public String getSrt() {
        return atalakit(ido1) + " --> " + atalakit(ido2);
    }

    /**
     * a felirat eltolása n másodperccel
     *
     * @param n az eltolás másodpercben
     */
    public void eltol(int n) {
        ido1 += n;
        ido2 += n;
    }

    /**
     * Felirat osztály tesztelés
     *
     */
    public static void main() {
        Felirat f1 = new Felirat("00:14 - 00:16",
                "So the tank model looks like this");
        Felirat f2 = new Felirat("65:31 - 65:34",
                "And that's the end of phase 2.");
        System.out.println(f1.getSrt());
        System.out.println(f1.getSZOVEG());
        System.out.println(f2.getSrt());
        System.out.println(f2.getSZOVEG());
        f1.eltol(1);
        f2.eltol(-1);
        System.out.println(f1.getSrt());
        System.out.println(f1.getSZOVEG());
        System.out.println(f2.getSrt());
        System.out.println(f2.getSZOVEG());
    }
}
