package java20190515_16;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kjg
 */
public class Java20190515_16 {

    private static final Caesar c = new Caesar();

    private static void f_try_catch() {
        PrintWriter ki;
        try (Scanner be = new Scanner(new File("src/txt/vers.txt"));
                FileWriter fki = new FileWriter("src/txt/ki.txt", true)) {
            ki = new PrintWriter(fki);
            String sor;
            while (be.hasNextLine()) {
                sor = be.nextLine();
                ki.println(c.titkosit(sor, -3));
                System.out.println(sor);
            }
        } catch (IOException ex) {
            Logger.getLogger(Java20190515_16.class.getName()).log(Level.SEVERE,
                    null, ex);
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println(c.titkosit("íöüóőúéáű", 0));
        System.out.println(c.titkosit("ABC", 1));
        System.out.println(c.titkosit("ABC", -1));

        File fbe = new File("src/txt/vers.txt");
        Scanner be = new Scanner(fbe);
        FileWriter fki = new FileWriter("src/txt/ki.txt");
        PrintWriter ki = new PrintWriter(fki);
        String sor;
        while (be.hasNextLine()) {
            sor = be.nextLine();
            ki.println(c.titkosit(sor, 3));
            System.out.println(sor);
        }
        ki.println();
        be.close();
        ki.close();
        f_try_catch();
    }
}
