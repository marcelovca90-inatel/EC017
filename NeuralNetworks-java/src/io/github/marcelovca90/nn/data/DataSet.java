package io.github.marcelovca90.nn.data;

import java.util.Arrays;
import java.util.stream.DoubleStream;

public class DataSet
{
    private double[][] samples;
    private double[] labels;

    public DataSet(double[][] samples, double[] labels)
    {
        this.samples = samples;
        this.labels = labels;
    }

    public DataSet(double[][] samples, double[] labels, double bias)
    {
        this(samples, labels);
        for (int i = 0; i < samples.length; i++)
            this.samples[i] = concatenateArrays(new double[] { bias }, this.samples[i]);
    }

    public double[][] getSamples()
    {
        return samples;
    }

    public double[] getLabels()
    {
        return labels;
    }

    public long getNumberOfClasses()
    {
        return DoubleStream.of(getLabels()).distinct().count();
    }

    public long getNumberOfFeatures()
    {
        return getSamples()[0].length;
    }

    public long getNumberOfSamples()
    {
        return getSamples().length;
    }

    private double[] concatenateArrays(double[] a, double[] b)
    {
        double[] both = Arrays.copyOf(a, a.length + b.length);
        System.arraycopy(b, 0, both, a.length, b.length);
        return both;
    }
}
