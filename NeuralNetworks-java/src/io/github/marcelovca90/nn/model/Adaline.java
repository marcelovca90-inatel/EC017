package io.github.marcelovca90.nn.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import io.github.marcelovca90.nn.data.DataSet;
import io.github.marcelovca90.nn.math.ActivationFunction;
import io.github.marcelovca90.nn.math.MathUtils;
import io.github.marcelovca90.nn.plot.PlotUtils;

public class Adaline implements NeuralNetwork
{
    private double[][] x;
    private double[] d;
    private double n;
    private double[] w;
    private ActivationFunction g;
    private double e;
    private List<Double> plotDataX;
    private List<Double> plotDataY;

    public Adaline(double n, ActivationFunction g, double e)
    {
        this.n = n;
        this.g = g;
        this.e = e;
    }

    @Override
    public double[] train(DataSet dataSet)
    {
        x = dataSet.getSamples();
        d = dataSet.getLabels();
        w = new Random(42L).doubles(dataSet.getNumberOfFeatures()).toArray();
        this.plotDataX = new ArrayList<>();
        this.plotDataY = new ArrayList<>();

        int epoch = 0;
        double[] vArray = new double[(int) dataSet.getNumberOfSamples()];
        double mseBefore, mseAfter;

        do
        {
            // calculate mse before weights adjustments
            for (int i = 0; i < dataSet.getNumberOfSamples(); i++)
                vArray[i] = MathUtils.dotProduct(x[i], w);
            mseBefore = MathUtils.meanSquaredError(vArray, d);

            // adjust synaptic weights
            for (int i = 0; i < dataSet.getNumberOfSamples(); i++)
            {
                double v = MathUtils.dotProduct(x[i], w);
                for (int j = 0; j < dataSet.getNumberOfFeatures(); j++)
                    w[j] += (n * (d[i] - v) * x[i][j]);
            }

            // calculate mse after weights adjustments
            for (int i = 0; i < dataSet.getNumberOfSamples(); i++)
                vArray[i] = MathUtils.dotProduct(x[i], w);
            mseAfter = MathUtils.meanSquaredError(vArray, d);

            epoch++;
            System.err.printf("Epoch: %d\tWeights: %s\tError: %s\n", epoch, Arrays.toString(w), mseAfter);
            plotDataX.add((double) epoch);
            plotDataY.add(mseAfter);

        } while (Double.compare(Math.abs(mseAfter - mseBefore), e) >= 0);

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

    public void plotMeanSquaredErrorPerEpoch()
    {
        PlotUtils.plot(
            plotDataX.stream().mapToDouble(Double::doubleValue).toArray(),
            "epoch",
            plotDataY.stream().mapToDouble(Double::doubleValue).toArray(),
            "mse");
    }
}
