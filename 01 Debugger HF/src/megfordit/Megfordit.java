package megfordit;

import java.util.Scanner;

public class Megfordit {

    static void fordit(String s) {
        String f = "";
        for (int i = 0; i < s.length(); i++) {
            f = s.charAt(i) + f;
        }
        System.out.println("Megfordítva: " + f);        
    }
    
    public static void main(String[] args) {     
        Scanner bill = new Scanner(System.in,"Cp1250");
        System.out.print("Szöveg: ");
        String mit = bill.nextLine();
        while (!mit.equals("")) {
            fordit(mit);
            System.out.print("Szöveg: ");
            mit = bill.nextLine();
        }
    }
}
