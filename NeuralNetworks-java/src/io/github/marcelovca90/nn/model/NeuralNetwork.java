package io.github.marcelovca90.nn.model;

import io.github.marcelovca90.nn.data.DataSet;

public interface NeuralNetwork
{
    public double[] train(DataSet dataSet);

    public double test(double[] weights, double[] sample);

    public double evaluate(double[] weights, DataSet dataSet);
}
