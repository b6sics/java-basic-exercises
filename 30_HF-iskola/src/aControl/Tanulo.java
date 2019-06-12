package aControl;

/**
 * a tanuló jáva osztály
 *
 * @author KjG
 */
public class Tanulo {

    private String ev;
    private String osztaly;
    private String nev;
    private String azon;

    /**
     *
     * @param s a tanuló adatait tartalmazó szöveges változó
     */
    public Tanulo(String s) {
        String[] t = s.split(" ", 4);
        ev = t[0];
        osztaly = t[1];
        nev = t[2] + " " + t[3];
        azon = ev.charAt(3) + osztaly
                + t[2].substring(0, 3).toLowerCase()
                + t[3].substring(0, 3).toLowerCase();
    }

    /**
     *
     * @return a tanév
     */
    public String getEv() {
        return ev;
    }

    /**
     *
     * @return az osztály jele
     */
    public String getOsztaly() {
        return osztaly;
    }

    /**
     *
     * @return a tanuló neve
     */
    public String getNev() {
        return nev;
    }

    /**
     *
     * @return a tanuló azonosítója
     */
    public String getAzon() {
        return azon;
    }
}
