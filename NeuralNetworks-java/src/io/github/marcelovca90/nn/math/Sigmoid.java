package io.github.marcelovca90.nn.math;

public class Sigmoid implements ActivationFunction
{

    @Override
    public double compute(double v)
    {
        return (1 / (1 + Math.pow(Math.E, (-1 * v))));
    }

    @Override
    public double computeFirstDerivative(double v)
    {
        double fv = compute(v);
        return fv * (1.0 - fv);
    }
}
