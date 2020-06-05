package io.github.marcelovca90.nn.data.sample;

import io.github.marcelovca90.nn.data.DataSet;

public class LogicGateAND extends DataSet
{
    private static final double[][] _SAMPLES = new double[][] {
            { 0.0, 0.0 },
            { 0.0, 1.0 },
            { 1.0, 0.0 },
            { 1.0, 1.0 }
    };

    private static final double[] _LABELS = new double[] {
            0.0,
            0.0,
            0.0,
            1.0
    };

    private static final double BIAS = -1.0;

    public LogicGateAND()
    {
        super(_SAMPLES, _LABELS, BIAS);
    }
}
