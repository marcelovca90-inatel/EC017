package io.github.marcelovca90.nn.math;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class HeavisideSymmetricTest
{
    private static final double PRECISION = 1e-9;

    private ActivationFunction function = new HeavisideSymmetric();

    @Test
    public void compute_valueSmallerThanZero_shouldReturnMinusOne()
    {
        // given
        double v = -0.5;

        // when
        double fv = function.compute(v);

        // then
        assertEquals(-1.0, fv, PRECISION);
    }

    @Test
    public void compute_valueEqualToZero_shouldReturnZero()
    {
        // given
        double v = 0.0;

        // when
        double fv = function.compute(v);

        // then
        assertEquals(0.0, fv, PRECISION);
    }

    @Test
    public void compute_valueGreaterThanZero_shouldReturnOne()
    {
        // given
        double v = +0.5;

        // when
        double fv = function.compute(v);

        // then
        assertEquals(+1.0, fv, PRECISION);
    }

    @Test
    public void computeFirstDerivative_shouldAlwaysReturnZero()
    {
        // given
        double v = System.currentTimeMillis();

        // when
        double fv = function.computeFirstDerivative(v);

        // then
        assertEquals(0.0, fv, PRECISION);
    }
}
