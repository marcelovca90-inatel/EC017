package io.github.marcelovca90.nn.math;

public interface ActivationFunction
{
    public double compute(double v);

    public double computeFirstDerivative(double v);
}
