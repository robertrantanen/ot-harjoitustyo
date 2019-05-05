package domain;

import calculator.domain.Calculus;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculusTest {

    Calculus calculator;

    @Before
    public void setUp() throws Exception {
        calculator = new Calculus();
    }

    @Test
    public void plusWorks() throws Exception {
        assertEquals("2", calculator.calculate("1 + 1"));
    }

    @Test
    public void minusWorks() throws Exception {
        assertEquals("1", calculator.calculate("3 - 2"));
    }

    @Test
    public void multiplyWorks() throws Exception {
        assertEquals("30", calculator.calculate("5 * 6"));
    }

    @Test
    public void divideWorks() throws Exception {
        assertEquals("0.5", calculator.calculate("1 / 2"));
    }

    @Test
    public void powWorks() throws Exception {
        assertEquals("27", calculator.calculate("3 ^ 3"));
    }

    @Test
    public void rootWorks() throws Exception {
        assertEquals("3", calculator.calculate("27 root 3"));
    }

    @Test
    public void cantDivideWithZero() throws Exception {
        assertEquals("error", calculator.calculate("1 / 0"));
    }

    @Test
    public void CantRootWithZero() throws Exception {
        assertEquals("error", calculator.calculate("27 root 0"));
    }

    @Test
    public void emptyRemainsEmpty() throws Exception {
        assertEquals("", calculator.calculate(""));
    }

    @Test
    public void decimalsWork() throws Exception {
        assertEquals("1.11", calculator.calculate("1.1 + .01"));
    }

    @Test
    public void properErrorMessage() throws Exception {
        assertEquals("error", calculator.calculate(". + -"));
    }

    @Test
    public void properErrorMessage2() throws Exception {
        assertEquals("error", calculator.calculate("1.1.1.1.1 + 1.1.1.1"));
    }

    @Test
    public void getLastWorks() throws Exception {
        calculator.calculate("1 + 1");
        calculator.calculate("2 + 2");
        assertEquals("4", calculator.getLast());
    }

    @Test
    public void getLastItemsFromHistoryWorks() throws Exception {
        calculator.deleteHistory();
        calculator.calculate("1 + 1");
        assertEquals("1 + 1 = 2" + "\n", calculator.getLastItemsFromHistory());
    }

    @Test
    public void getLastItemsFromHistoryWithMultipleItems() throws Exception {
        calculator.deleteHistory();
        calculator.calculate("1 + 1");
        calculator.calculate("2 + 2");
        calculator.calculate("3 + 3");
        assertEquals("1 + 1 = 2" + "\n"
                + "2 + 2 = 4" + "\n"
                + "3 + 3 = 6" + "\n", calculator.getLastItemsFromHistory());
    }

    @Test
    public void getLastItemsFromHistoryWithOver10Items() throws Exception {
        calculator.deleteHistory();
        calculator.calculate("1 + 1");
        calculator.calculate("2 + 2");
        calculator.calculate("3 + 3");
        calculator.calculate("4 + 4");
        calculator.calculate("5 + 5");
        calculator.calculate("6 + 6");
        calculator.calculate("7 + 7");
        calculator.calculate("8 + 8");
        calculator.calculate("9 + 9");
        calculator.calculate("10 + 10");
        calculator.calculate("11 + 11");
        assertEquals("2 + 2 = 4" + "\n"
                + "3 + 3 = 6" + "\n"
                + "4 + 4 = 8" + "\n"
                + "5 + 5 = 10" + "\n"
                + "6 + 6 = 12" + "\n"
                + "7 + 7 = 14" + "\n"
                + "8 + 8 = 16" + "\n"
                + "9 + 9 = 18" + "\n"
                + "10 + 10 = 20" + "\n"
                + "11 + 11 = 22" + "\n", calculator.getLastItemsFromHistory());
    }

    @Test
    public void sinFunctionWorks() throws Exception {
        assertEquals("0.84147", calculator.calculateTrigonometric("sin(1)"));
    }

    @Test
    public void cosFunctionWorks() throws Exception {
        assertEquals("0.5403", calculator.calculateTrigonometric("cos(1)"));
    }

    @Test
    public void tanFunctionWorks() throws Exception {
        assertEquals("1.55741", calculator.calculateTrigonometric("tan(1)"));
    }

    @Test
    public void calculateTrigonometricReturnsParamaterIfNothingToCalculate() throws Exception {
        assertEquals("sin()", calculator.calculateTrigonometric("sin()"));
    }

    @Test
    public void deleteHistoryWorks() throws Exception {
        calculator.calculate("1 + 1");
        calculator.deleteHistory();
        assertEquals("", calculator.getLastItemsFromHistory());
    }

}
