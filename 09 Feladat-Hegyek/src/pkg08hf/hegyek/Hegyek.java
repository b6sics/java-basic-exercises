package pkg08hf.hegyek;

import java.io.*;

/**
 *
 * @author KissJGabi
 */
public class Hegyek {

    private static RandomAccessFile f;
    private static String[] hegyek;
    private static final String SOURCEFILE = "hegyek.txt";
    private static final String TARGETFILE = "OUTPUT.txt";

    private static String f00(int hossz, char jel, String name) {
        int start = 0;
        String str = "";
        if (name.length() != 0) {
            start = name.length() + 5;
            str = jel + "| ";
            str += name + " |";
        }
        for (int ii = start; ii < hossz; ii++) {
            str += jel;
        }
        str += "\n";
        System.out.println(str);
        return str;
    }

    // --- textdekoráció metódus vége
    // --- fájl metódusok
    private static String inputFile(String fileName, String mode) {
        try {
            f = new RandomAccessFile(fileName, mode);
            String sor = f.readLine();
            hegyek = sor.split("\\s*,\\s*");
            f.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
        String str = "\t" + fileName + "... beolvasva!";
        System.out.println(str);
        return str;
    }

    private static void appendFile(String fileName, String mode, String str) {
        try {
            f = new RandomAccessFile(fileName, mode);
            f.seek(f.length());     //a fájlmutatót a fájl végére mozgatja
            f.writeBytes(str + "\n");
            f.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }

    private static void deleteFile(String fileName) {
        File file = new File(fileName);
        if (file.exists()) {
            file.delete();
        }
    }

    // --- fájl metódusok vége
    // --- a feladat metódusai
    private static void f0(String label, String fileName, String mode) {
        appendFile(TARGETFILE, "rw", f00(60, '-', label));
        appendFile(TARGETFILE, "rw", inputFile(fileName, mode));
        // System.out.println("Hegyek: " + Arrays.toString(hegyek));
        System.out.println("");
        appendFile(TARGETFILE, "rw", "\n");
    }

    private static void f1(String label, int limit) {
        appendFile(TARGETFILE, "rw", f00(60, '-', label));
        String str = "A lista: \n";
        int db = 0;
        for (String hegy : hegyek) {
            if (Integer.parseInt(hegy) > limit) {
                db++;
                str += hegy + " ";
            }
        }
        System.out.println(str);
        appendFile(TARGETFILE, "rw", str);
        str = "\nÖsszesen:\n" + db + " db";
        System.out.println(str);
        appendFile(TARGETFILE, "rw", str);
        System.out.println("");
        appendFile(TARGETFILE, "rw", "\n");
    }

    private static void f2(String label) {
        appendFile(TARGETFILE, "rw", f00(60, '-', label));
        int legmagasabb = 0;
        for (String hegy : hegyek) {
            if (Integer.parseInt(hegy) > legmagasabb) {
                legmagasabb = Integer.parseInt(hegy);
            }
        }
        String str = "maximum: " + legmagasabb + " m.";
        System.out.println(str);
        appendFile(TARGETFILE, "rw", str);
        System.out.println("");
        appendFile(TARGETFILE, "rw", "\n");
    }

    private static void f3(String label, int difference) {
        appendFile(TARGETFILE, "rw", f00(60, '-', label));
        int first, second;
        first = Integer.parseInt(hegyek[0]);
        for (int ii = 1; ii < hegyek.length; ii++) {
            second = Integer.parseInt(hegyek[ii]);
            if (Math.abs(first - second) >= difference) {
                String str = String.format("%4d", second - first);
                str = first + " " + second + " (" + str + ")";
                System.out.println(str);
                appendFile(TARGETFILE, "rw", str);
            }
            first = second;
        }
        System.out.println("");
        appendFile(TARGETFILE, "rw", "\n");
    }

    private static void f4(String label) {
        appendFile(TARGETFILE, "rw", f00(60, '-', label));
        int first, second, third;
        first = Integer.parseInt(hegyek[0]);
        for (int ii = 1; ii < hegyek.length - 1; ii++) {
            second = Integer.parseInt(hegyek[ii]);
            third = Integer.parseInt(hegyek[ii + 1]);
            if (second - first > 0 && third - second < 0) {
                String str = String.format("%4d ", first);
                str += String.format("%4d ", second);
                str += String.format("%4d", third);
                System.out.println(str);
                appendFile(TARGETFILE, "rw", str);
            }
            first = second;
        }
        System.out.println("");
        appendFile(TARGETFILE, "rw", "\n");
    }

    // --- a feladat metódusai vége
    // --- fő program
    public static void main(String[] args) {
        deleteFile(TARGETFILE);
        appendFile(TARGETFILE, "rw", f00(60, '*', "STARTofJAVA 2019mar29 HF hegyek"));
        appendFile(TARGETFILE, "rw", f00(60, '-', ""));

        f0("0. Beolvasás ", SOURCEFILE, "r");
        f1("1. A 800 m feletti pontok", 800);
        f2("2. A legmagasabb pont");
        f3("3. Legalább 100 m a különbség", 100);
        f4("4. Csúcsok");

        appendFile(TARGETFILE, "rw", f00(60, '-', ""));
        appendFile(TARGETFILE, "rw", f00(60, '*', "ENDofJAVA   2019mar29"));
    }
    // --- fő program vége
}
