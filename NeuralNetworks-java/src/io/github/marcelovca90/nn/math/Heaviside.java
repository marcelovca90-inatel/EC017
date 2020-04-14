package io.github.marcelovca90.nn.math;

public class Heaviside implements ActivationFunction
{
    @Override
    public double compute(double v)
    {
        // v is less than zero
        if (Double.compare(v, 0.0) < 0)
            return 0.0;
        // v is greater than or equal to zero
        else
            return 1.0;
    }

    @Override
    public double computeFirstDerivative(double v)
    {
        return 0.0;
    }
}
