package io.github.marcelovca90.nn.math;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import io.github.marcelovca90.nn.math.MathUtils;

public class MathUtilsTest
{
    @Test
    public void constructor_shouldReturnNonNullObject()
    {
        // when
        MathUtils utils = new MathUtils();

        // then
        assertNotNull(utils);
    }

    @Test
    public void dotProduct_valuesShouldMatch()
    {
        // given
        double[] d1 = { 1.0, 2.0, 3.0 };
        double[] d2 = { 4.0, 5.0, 6.0 };

        // when
        double ans = MathUtils.dotProduct(d1, d2);

        // then
        assertEquals(32.0, ans, 1e-9);
    }
}
