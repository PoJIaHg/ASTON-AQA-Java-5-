import org.testng.Assert;
import org.testng.annotations.Test;

public class FactorialCalculatorTest {

    @Test
    public void testCalculateFactorialWithPositiveNumber() {
        Assert.assertEquals(FactorialCalculator.calculateFactorial(0), 1);
        Assert.assertEquals(FactorialCalculator.calculateFactorial(1), 1);
        Assert.assertEquals(FactorialCalculator.calculateFactorial(6), 720);

    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testCalculateFactorialWithNegativeNumber() {
        FactorialCalculator.calculateFactorial(-1);
    }
}