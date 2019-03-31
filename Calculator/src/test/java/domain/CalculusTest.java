package domain;

import calculator.domain.Calculus;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class CalculusTest {

    Calculus calculator;

    @Before
    public void setUp() {
        calculator = new Calculus();
    }

    @Test
    public void plusWorks() {
        assertEquals("2", calculator.calculate("1 + 1"));
    }

    @Test
    public void minusWorks() {
        assertEquals("1", calculator.calculate("3 - 2"));
    }

    @Test
    public void multiplyWorks() {
        assertEquals("30", calculator.calculate("5 * 6"));
    }

    @Test
    public void divideWorks() {
        assertEquals("0.5", calculator.calculate("1 / 2"));
    }

    @Test
    public void cantDivideWithZero() {
        assertEquals("error", calculator.calculate("1 / 0"));
    }

    @Test
    public void emptyRemainsEmpty() {
        assertEquals("", calculator.calculate(""));
    }

}
