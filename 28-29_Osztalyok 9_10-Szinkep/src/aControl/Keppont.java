/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aControl;

/**
 *
 * @author KjG
 */
public class Keppont {

    private String szin;

    public String getSzin() {
        return szin;
    }

    public void setSzin(String szin) {
        this.szin = szin;
    }

    public Keppont(String szin) {
        this.szin = szin;
    }

    public String szinjel() {
        switch (szin) {
            case "255 0 0":
                return "V";
            case "0 255 0":
                return "Z";
            case "0 0 255":
                return "K";
            case "255 255 0":
                return "S";
            case "255 0 255":
                return "M";
            case "0 0 0":
                return "F";
            case "200 96 64":
                return "-";
            default:
                return " ";
        }
    }
}
