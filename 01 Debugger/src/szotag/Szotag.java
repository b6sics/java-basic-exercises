package szotag;

import java.util.Scanner;

public class Szotag {

    static void szotag(String s) {
        final String MH = "AÁEÉIÍOÓÖŐUÚÜŰ";
        int db = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (MH.indexOf(c) > -1) {
                db++;
            }
        }
        System.out.println(db);
    }

    public static void main(String[] args) {
        Scanner bill = new Scanner(System.in, "Cp1250");
        System.out.print("Szó: ");
        String mit = bill.nextLine().toUpperCase();
        while (!mit.equals("")) {
            szotag(mit);
            System.out.print("Szó: ");
            mit = bill.nextLine().toUpperCase();
        }
    }
}
