package tests;

import app.Calculator;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Alexandr on 30.04.2017.
 */
public class CalculatorTest {

    @Test
    public void test_1() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(3.0, calculator.calc(6, 2, "Division"));
    }

    @Test
    public void test_6() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(-1.0, calculator.calc(6, 0, "Division"));
    }

    @Test
    public void test_2() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(12.0, calculator.calc(6, 2, "Multiply"));
    }

    @Test
    public void test_3() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(4.0, calculator.calc(6, 2, "Difference"));
    }

    @Test
    public void test_4() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(8.0, calculator.calc(6, 2, "Sum"));
    }
}
