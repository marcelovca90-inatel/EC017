package io.github.marcelovca90.nn.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import io.github.marcelovca90.nn.data.DataSet;
import io.github.marcelovca90.nn.math.ActivationFunction;
import io.github.marcelovca90.nn.math.MathUtils;
import io.github.marcelovca90.nn.plot.PlotUtils;

public class Perceptron implements NeuralNetwork
{
    private double[][] x;
    private double[] d;
    private double n;
    private double[] w;
    private ActivationFunction g;
    private List<Double> plotDataX;
    private List<Double> plotDataY;

    public Perceptron(double n, ActivationFunction g)
    {
        this.n = n;
        this.g = g;
        this.plotDataX = new ArrayList<>();
        this.plotDataY = new ArrayList<>();
    }

    @Override
    public double[] train(DataSet dataSet)
    {
        x = dataSet.getSamples();
        d = dataSet.getLabels();
        w = new Random(42L).doubles(dataSet.getNumberOfFeatures()).toArray();

        int epoch = 0;
        boolean error;

        do
        {
            error = false;
            for (int i = 0; i < dataSet.getNumberOfSamples(); i++)
            {
                double v = MathUtils.dotProduct(x[i], w);
                double y = g.compute(v);
                if (Double.compare(y, d[i]) != 0)
                {
                    for (int j = 0; j < dataSet.getNumberOfFeatures(); j++)
                    {
                        w[j] += (n * (d[i] - y) * x[i][j]);
                    }
                    error = true;
                }
            }
            epoch++;
            System.err.printf("Epoch: %d\tWeights: %s\n", epoch, Arrays.toString(w));
            plotDataX.add((double) epoch);
            plotDataY.add(error ? 1.0 : 0.0);

        } while (error && epoch < 10000);

        return Arrays.copyOf(w, w.length);
    }

    @Override
    public double test(double[] weights, double[] sample)
    {
        double v = MathUtils.dotProduct(w, sample);
        double y = g.compute(v);
        return y;
    }

    @Override
    public double evaluate(double[] weights, DataSet dataSet)
    {
        x = dataSet.getSamples();
        d = dataSet.getLabels();
        long correct = 0;
        long total = dataSet.getNumberOfSamples();
        for (int i = 0; i < dataSet.getNumberOfSamples(); i++)
        {
            double y = test(weights, x[i]);
            if (Double.compare(y, d[i]) == 0)
            {
                correct++;
            }
        }
        double accuracy = (double) correct / (double) total;
        System.out.printf("Accuracy: %.2f%% (%d/%d)\n", 100.0 * accuracy, correct, total);
        return accuracy;
    }

    public void plotErrorPerEpoch()
    {
        PlotUtils.plot(
            plotDataX.stream().mapToDouble(Double::doubleValue).toArray(),
            "epoch",
            plotDataY.stream().mapToDouble(Double::doubleValue).toArray(),
            "error");
    }
}
