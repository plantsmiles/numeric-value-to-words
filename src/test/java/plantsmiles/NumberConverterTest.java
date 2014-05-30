package plantsmiles;

import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

/**
 * Created by john.samuelson on 5/29/14.
 */
public class NumberConverterTest {

    @Test
    public void testNegativeNumber() {
        final BigDecimal number = new BigDecimal("-34.06");

        assertEquals(NumberConverter.convertNumberToWords(number), "minus thirty-four 6/100 dollars");
    }

    @Test
    public void testZero() {
        final BigDecimal number = new BigDecimal("0");

        assertEquals(NumberConverter.convertNumberToWords(number), "zero dollars");
    }

    @Test
    public void testTensNumber() {
        final BigDecimal number = new BigDecimal("40");

        assertEquals(NumberConverter.convertNumberToWords(number), "forty dollars");
    }

    @Test
    public void testHundredNumber() {
        final BigDecimal number = new BigDecimal("700");

        assertEquals(NumberConverter.convertNumberToWords(number), "seven hundred dollars");
    }

    @Test
    public void testHundredsNumber() {
        final BigDecimal number = new BigDecimal("233");

        assertEquals(NumberConverter.convertNumberToWords(number), "two hundred thirty-three dollars");
    }

    @Test
    public void testThousandsNumber() {
        final BigDecimal number = new BigDecimal("98840");

        assertEquals(NumberConverter.convertNumberToWords(number), "ninety-eight thousand eight hundred forty dollars");
    }

    @Test
    public void testHundredsThousandNumber() {
        final BigDecimal number = new BigDecimal("398746");

        assertEquals(NumberConverter.convertNumberToWords(number), "three hundred ninety-eight thousand seven hundred " +
                "forty-six dollars");
    }

    @Test
    public void testMillionNumber() {
        final BigDecimal number = new BigDecimal("7498324");

        assertEquals(NumberConverter.convertNumberToWords(number), "seven million four hundred ninety-eight " +
                "thousand three hundred twenty-four dollars");
    }

    @Test
    public void testNumberWithOneDecimalPlaces() {
        final BigDecimal number = new BigDecimal("23.8");

        assertEquals(NumberConverter.convertNumberToWords(number), "twenty-three 80/100 dollars");
    }

    @Test
    public void testNumberWithTwoDecimalPlaces() {
        final BigDecimal number = new BigDecimal("9523.04");

        assertEquals(NumberConverter.convertNumberToWords(number), "nine thousand five hundred twenty-three 4/100 " +
                "dollars");
    }

    @Test
    public void testNumberWithThreeDecimalPlacesRoundDown() {
        final BigDecimal number = new BigDecimal("501.045");

        assertEquals(NumberConverter.convertNumberToWords(number), "five hundred one 4/100 dollars");
    }

    @Test
    public void testNumberWithThreeDecimalPlacesRoundUp() {
        final BigDecimal number = new BigDecimal("501.046");

        assertEquals(NumberConverter.convertNumberToWords(number), "five hundred one 5/100 dollars");
    }
}
