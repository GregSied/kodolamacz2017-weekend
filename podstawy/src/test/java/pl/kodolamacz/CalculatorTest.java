package pl.kodolamacz;

import org.hamcrest.Matcher;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;


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
        Assert.assertEquals(
                "Wynik mnożenia powinien być 35",
                35, result);
//        Assert.assertEquals(0.3, .1+.1+.1, 1e-18);

        Assert.assertThat(result, is(equalTo(35)));
    }

}
