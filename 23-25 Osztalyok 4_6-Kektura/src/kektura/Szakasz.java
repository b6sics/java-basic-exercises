package kektura;

/**
 *
 * @author KjG
 */
public class Szakasz {

    private String eleje;
    private String vege;
    private double tav;
    private int emelkedes;
    private int lejtes;
    private boolean pecsethely;

    /**
     * szakasz osztály konstruktora
     *
     * @param sor a beolvasott sor
     */
    public Szakasz(String sor) {
        String[] s = sor.split(";");
        this.eleje = s[0];
        this.vege = s[1];
        this.tav = Double.parseDouble(s[2].replace(",", "."));
        this.emelkedes = Integer.parseInt(s[3]);
        this.lejtes = Integer.parseInt(s[4]);
        this.pecsethely = s[5].equals("i");
    }

    /**
     * Megadja a szakasz hosszát
     *
     * @return tav
     */
    public double getTav() {
        return tav;
    }

    /**
     * Megadja a szakasz szintváltozását
     *
     * @return
     */
    public int szintvaltozas() {
        return emelkedes - lejtes;
    }

    /**
     * Megvizsgálja, hogy hiányos-e a végpontnév
     *
     * @return igaz/hamis
     */
    public boolean hianyos() {
        return pecsethely && !vege.contains("pecsetelohely");
    }

    /**
     * ha nem szerepel a pecsételőhely a névben, akkor hozzáírja
     */
    public void javit() {
        if (hianyos()) {
            vege += " pecsetelohely";
        }
    }

    /**
     * szakasz stringgé alakítása
     *
     * @return
     */
    @Override
    public String toString() {
        return String.format("%s;%s;%.3f;%d;%d;%s;",
                eleje, vege, tav, emelkedes, lejtes, pecsethely ? "i" : "n");
    }

    /**
     * teszteléshez ctrl+Shift+F5
     *
     * @param args
     */
    public static void main(String[] args) {
        Szakasz sz1 = new Szakasz("Sumeg, vasutallomas;"
                + "Sumeg, buszpalyaudvar;1,208;16;6;n");
        System.out.println(sz1);
        System.out.println(sz1.hianyos());

        Szakasz sz2 = new Szakasz("Sumeg, vasutallomas;"
                + "Sumeg, buszpalyaudvar;1,208;16;6;n");
        System.out.println(sz2);
        System.out.println(sz2.hianyos());

        Szakasz sz3 = new Szakasz("Rezi, leteres a pecsetelohelyhez;"
                + "Gyongyosi csarda;2,535;31;173;i");
        System.out.println(sz3);
        System.out.println(sz3.hianyos());
    }
}
