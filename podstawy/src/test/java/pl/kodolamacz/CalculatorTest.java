package pl.kodolamacz;

import org.junit.Assert;
import org.junit.Test;


public class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    public void shouldAddTwoValues(){
        // given - co na wejściu
        int a = 5;
        int b = 7;

        // when - co się ma zadziać
        int result = calculator.add(a, b);

        // then - co powinno wyjść
        Assert.assertEquals(12, result);
    }

    @Test
    public void shouldSubtractTwoValuesTest(){
        // given
        int a = 16;
        int b = 7;
        // when
        int result = calculator.minus(16, 7);

        // then
        Assert.assertEquals(9, result);
    }

    @Test
    public void shouldMultiplyTest(){
        // given
        int a = 5;
        int b = 7;

        // when
        int result = calculator.multiply(a,b);

        // then
        Assert.assertEquals(35, result);
    }

}
