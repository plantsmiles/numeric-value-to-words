package plantsmiles;

import java.math.BigDecimal;

/**
 * Created by john.samuelson on 5/29/14.
 */
public class NumericValueConverter {
    public static void main(String[] args) {
        String[] tst = {"2523.111", "1133", "9494302.006"};
        for (String numberToConvert : tst) {
            System.out.println("Converted Value: " + numberToConvert + " => " +
                    NumberConverter.convertNumberToWords(new BigDecimal(numberToConvert)));
        }
    }
}
