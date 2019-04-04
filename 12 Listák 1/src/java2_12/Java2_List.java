package java2_12;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author KjG
 */
public class Java2_List {

    public static ArrayList<String> lista = new ArrayList<>();

    private static void f0() {
        String str = "| Segítség:\n";
        str += "| [Enter] - kilépés\n";
        str += "| ELEM_NeVE és [Enter] - új elem hozzáadása a lista végéhez\n";
        str += "| '*'+ELEM_NEVE és [Enter] - új elem hozzáadása a lista elejéhez\n";
        str += "| '-'+ELEM_SZÁMA és [Enter] - elem törlése\n";
        System.out.println(str);
    }

    private static void kiir() {
        for (int ii = 0; ii < lista.size(); ii++) {
            System.out.println(ii + " " + lista.get(ii));
        }
    }

    private static void f1() {
        lista.add("Tanulás");
        lista.add("Bevásárlás");
        lista.add("Filmnézés");
        System.out.println(lista);
        System.out.println("Méret: " + lista.size());
        System.out.println("");
    }

    private static void f2() {
        Scanner sc = new Scanner(System.in, "Cp1250");
        System.out.print("f2()> ");
        String input = sc.nextLine();
        while (!input.equals("")) {
            lista.add(input);
            System.out.println(lista);
            System.out.println("Méret: " + lista.size());
            System.out.print("f2()> ");
            input = sc.nextLine();
        }
        System.out.println("");
    }

    private static void f3() {
        Scanner sc = new Scanner(System.in, "Cp1250");
        System.out.print("f3()> ");
        String input = sc.nextLine();
        while (!input.equals("")) {
            if (input.charAt(0) == '*') {
                lista.add(0, input.substring(1));
            } else {
                lista.add(input);
            }
            kiir();
            System.out.println("Méret: " + lista.size());
            System.out.print("f3()> ");
            input = sc.nextLine();
        }
        System.out.println("");
    }

    private static void f4() {
        Scanner sc = new Scanner(System.in, "Cp1250");
        System.out.print("f4()> ");
        String input = sc.nextLine();
        while (!input.equals("")) {
            if (input.charAt(0) == '*') {
                lista.add(0, input.substring(1));
            } else if (input.charAt(0) == '-') {
                int n = Integer.parseInt(input.substring(1));
                if (n < lista.size()) {
                    lista.remove(n);
                }
            } else {
                lista.add(input);
            }
            kiir();
            System.out.println("Méret: " + lista.size());
            System.out.print("f4()> ");
            input = sc.nextLine();
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        f0();
        f1();
        f2();
        kiir();
        System.out.println("");
        f3();
        f4();
    }
}
