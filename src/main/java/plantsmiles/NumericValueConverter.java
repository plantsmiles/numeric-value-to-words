package plantsmiles;

import java.math.BigDecimal;

/**
 * Created by john.samuelson on 5/29/14.
 */
public class NumericValueConverter {
    public static void main(String[] args) {
        for (String numberToConvert : args) {
            try {
                System.out.println("Converted Value: " + numberToConvert + " => " +
                        NumberConverter.convertNumberToWords(new BigDecimal(numberToConvert)));
            } catch (NumberFormatException e) {
                System.out.println("Failed to convert '" + numberToConvert + "' Are you sure its a valid number?");
            }
        }
    }
}
