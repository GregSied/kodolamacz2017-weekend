package pl.kodolamacz;

import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

public class ArrayUtilsTest {

    @Test
    public void shouldCalculateMeanTest(){
        // given
        double[] array = {};

        // when
        double mean = ArrayUtils.mean(array);

        // then
        Assert.assertEquals(2.0, mean, 1e-14);
    }

    @Test
    public void shouldFindMaxValueTest(){
        // given
        double[] array = {1,23,5};
        // when
        Double max = ArrayUtils.max(array).orElseThrow(AssertionError::new);
        // then
        Assert.assertEquals((double) max, 23.0, 0.1);
    }

}
