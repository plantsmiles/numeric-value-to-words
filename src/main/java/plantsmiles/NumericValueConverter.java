package plantsmiles;

import java.math.BigDecimal;

/**
 * Created by john.samuelson on 5/29/14.
 */
public class NumericValueConverter {
    public static void main(String[] args) {
        String[] tst = {"2523.111", "1133", "9494302.006", "cannotConvert"};
        for (String numberToConvert : tst) {
            try {
                System.out.println("Converted Value: " + numberToConvert + " => " +
                        NumberConverter.convertNumberToWords(new BigDecimal(numberToConvert)));
            } catch (NumberFormatException e) {
                System.out.println("Failed to convert '" + numberToConvert + "' Are you sure its a valid number?");
            }

        }
    }
}
