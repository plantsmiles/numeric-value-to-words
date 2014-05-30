package plantsmiles;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by john.samuelson on 5/29/14.
 */
public class NumberConverter {
    private static final String[] UNDER_TWENTY = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight",
            "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen",
            "nineteen"};

    private static final String[] TENS = {"twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty",
            "ninety"};

    private static final String[] EXPONENTIAL = {"thousand", "million", "billion"};

    public static String convertNumberToWords(final BigDecimal incomingNumber) {
        final int wholeNumber = incomingNumber.intValue();
        final String wholeNumberWords = convertWholeNumberToWords(wholeNumber);

        String remainderValue = " dollars";
        if (incomingNumber.doubleValue() % 1 != 0) {
            // RoundingMode.HALF_DOWN - Rounding mode to round towards "nearest neighbor" unless both neighbors are
            // equidistant, in which case round down....which I believe is what the banks do.
            final BigDecimal roundedValue = incomingNumber.setScale(2, RoundingMode.HALF_DOWN);
            final BigDecimal intBigDecimal = new BigDecimal(roundedValue.toBigInteger());

            final BigDecimal fractionFromSubtraction = roundedValue.subtract(intBigDecimal);
            final int scale = fractionFromSubtraction.scale();
            final int intResult = fractionFromSubtraction.multiply(BigDecimal.TEN.pow(scale)).intValue();

            if (intResult > 0) {
                remainderValue = " " + Integer.toString(intResult) + "/100 dollars";
            }
        }

        return wholeNumberWords + remainderValue;
    }

    private static String convertWholeNumberToWords(int wholeNumber){
        if (wholeNumber <= 999) {
            return convertUpToThousand(wholeNumber);
        }

        String result = null;
        int placeHolder = 0;

        while (wholeNumber > 0) {
            if (wholeNumber % 1000 != 0) {
                String underThousand = convertUpToThousand(wholeNumber % 1000);

                if (placeHolder > 0) {
                    underThousand = underThousand + " " + EXPONENTIAL[placeHolder-1];
                }
                if (result == null) {
                    result = underThousand;
                }
                else {
                    result = underThousand + " " + result;
                }
            }

            wholeNumber /= 1000;
            placeHolder++;
        }
        return result;
    }

    private static String convertUpToThousand(int wholeNumber) {
        String hundredSomething = UNDER_TWENTY[wholeNumber / 100] + " hundred";
        String underHundredSomething = convertUpToHundred(wholeNumber % 100);

        if (wholeNumber <= 99) {
            return underHundredSomething;
        }
        else if (wholeNumber % 100 == 0) {
            return hundredSomething;
        }

        return hundredSomething + " " + underHundredSomething;
    }

    private static String convertUpToHundred(int wholeNumber) {
        if (wholeNumber < 20) {
            return UNDER_TWENTY[wholeNumber];
        }

        String overTwenty = TENS[wholeNumber / 10 - 2];

        if (wholeNumber % 10 == 0) {
            return overTwenty;
        }

        return overTwenty + "-" + UNDER_TWENTY[wholeNumber % 10];
    }
}
