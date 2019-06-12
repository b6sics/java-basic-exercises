/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aControl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author KjG
 */
public class Main {

    static ArrayList<Tanulo> tanulok = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        //beolvasás
        Scanner f = new Scanner(new File("src/aData/nevek.txt"));
        while (f.hasNextLine()) {
            tanulok.add(new Tanulo(f.nextLine()));
        }
        f.close();
        //tanulók száma
        System.out.println("Tanulók száma: " + tanulok.size());
        //leghosszabb név
        String nev = "";
        for (Tanulo t : tanulok) {
            if (t.getNev().length() > nev.length()) {
                nev = t.getNev();
            }
        }
        System.out.println("Leghosszabb név: " + nev);
        //osztály listázása
        Scanner bill = new Scanner(System.in);
        System.out.println("Osztály listázása");
        System.out.print("Évfolyam: ");
        String ev = bill.nextLine();
        System.out.print("Osztály: ");
        String osztaly = bill.nextLine();
        for (Tanulo t : tanulok) {
            if (t.getEv().equals(ev) && t.getOsztaly().equals(osztaly)) {
                System.out.println(t.getNev() + " " + t.getAzon());
            }
        }
    }
}
