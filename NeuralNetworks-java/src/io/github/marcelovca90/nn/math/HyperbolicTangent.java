package io.github.marcelovca90.nn.math;

public class HyperbolicTangent implements ActivationFunction
{

    @Override
    public double compute(double v)
    {
        return Math.tanh(v);
    }

    @Override
    public double computeFirstDerivative(double v)
    {
        double fv = compute(v);
        return 1.0 - Math.pow(fv, 2.0);
    }
}
