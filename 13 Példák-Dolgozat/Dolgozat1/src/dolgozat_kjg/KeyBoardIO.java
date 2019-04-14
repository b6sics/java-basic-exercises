package dolgozat_kjg;

import java.util.Scanner;

/**
 *
 * @author KissJGabi
 */
public class KeyBoardIO {

    private final String CHAR_SET;
    private final Scanner KB;

    public KeyBoardIO(String charSet) {
        this.CHAR_SET = charSet;
        KB = new Scanner(System.in, (this.CHAR_SET));
    }

    public String getString(String label) {
        String result;
        System.out.println(label);
        do {
            System.out.print(" >");
            result = KB.nextLine();
        } while (result.length() == 0);
        return result;
    }

    public boolean getChar(String label, String in) {
        String input;
        do {
            input = getString(label);
        } while (!(in.contains(input) && input.length() == 1));
        return input.charAt(0) != in.charAt(0);
    }

    public int getInt(String label) {
        boolean isInteger;
        int result;
        do {
            isInteger = true;
            result = 0;
            try {
                result = Integer.valueOf(getString(label));
            } catch (NumberFormatException e) {
                System.out.println("Egész számot kérek!");
                isInteger = false;
            }
        } while (!isInteger);
        return result;
    }

    public double getDouble(String label) {
        boolean isNumber;
        double result;
        do {
            isNumber = true;
            result = 0;
            try {
                result = Double.valueOf(getString(label));
            } catch (NumberFormatException e) {
                System.out.println("Számot kérek!");
                isNumber = false;
            }
        } while (!isNumber);
        return result;
    }
}
