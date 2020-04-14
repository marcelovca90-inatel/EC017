package io.github.marcelovca90.nn.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import io.github.marcelovca90.nn.data.DataSet;
import io.github.marcelovca90.nn.math.ActivationFunction;
import io.github.marcelovca90.nn.math.MathUtils;
import io.github.marcelovca90.nn.plot.PlotUtils;

public class MultilayerPerceptron
{
    private double[][] x;
    private double[] d;
    private double n;
    private int n1;
    private int n2;
    private int n3 = 1;
    private double[][] w1;
    private double[][] w2;
    private double[][] w3;
    private ActivationFunction g;
    private double e;
    private List<Double> plotDataX;
    private List<Double> plotDataY;
    private double[] i1, i2, i3;
    private double[] y1, y2, y3;

    public MultilayerPerceptron(double n, int n1, int n2, ActivationFunction g, double e)
    {
        this.n = n;
        this.n1 = n1;
        this.n2 = n2;
        this.g = g;
        this.e = e;
        this.plotDataX = new ArrayList<>();
        this.plotDataY = new ArrayList<>();
    }

    public double train(DataSet dataSet)
    {
        x = dataSet.getSamples();
        d = dataSet.getLabels();

        w1 = generateRandomSynapticWeightsMatrix((int) dataSet.getNumberOfFeatures(), n1);
        w2 = generateRandomSynapticWeightsMatrix(n1, n2);
        w3 = generateRandomSynapticWeightsMatrix(n2, n3);

        int epoch = 0;
        double[] yArray = new double[(int) dataSet.getNumberOfSamples()];
        double mseBefore, mseAfter;

        do
        {
            // calculate mse before weights adjustments
            for (int i = 0; i < dataSet.getNumberOfSamples(); i++)
                yArray[i] = feedForward(dataSet, i)[0];
            mseBefore = MathUtils.meanSquaredError(yArray, d);

            // feed samples forwards, propagate error backwards and ajust weights
            for (int sampleIndex = 0; sampleIndex < dataSet.getNumberOfSamples(); sampleIndex++)
            {
                feedForward(dataSet, sampleIndex);
                backPropagate(dataSet, sampleIndex);
            }

            // calculate mse after weights adjustments
            for (int i = 0; i < dataSet.getNumberOfSamples(); i++)
                yArray[i] = feedForward(dataSet, i)[0];
            mseAfter = MathUtils.meanSquaredError(yArray, d);

            epoch++;
            System.err.printf("Epoch: %d\tError: %s\n", epoch, mseAfter);
            plotDataX.add((double) epoch);
            plotDataY.add(mseAfter);

        } while (Double.compare(Math.abs(mseAfter - mseBefore), e) >= 0);

        return mseAfter;
    }

    public double evaluate(DataSet dataSet)
    {
        x = dataSet.getSamples();
        d = dataSet.getLabels();
        long correct = 0;
        long total = dataSet.getNumberOfSamples();
        for (int i = 0; i < dataSet.getNumberOfSamples(); i++)
        {
            double y = Math.signum(feedForward(dataSet, i)[0]);
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

    private double[] feedForward(DataSet dataSet, int k)
    {
        // i1
        i1 = new double[n1];
        for (int i = 0; i < dataSet.getNumberOfFeatures(); i++)
            for (int j = 0; j < n1; j++)
                i1[j] += x[k][i] * w1[i][j];

        // y1
        y1 = new double[n1];
        for (int j = 0; j < n1; j++)
            y1[j] = g.compute(i1[j]);

        // i2
        i2 = new double[n2];
        for (int i = 0; i < n1; i++)
            for (int j = 0; j < n2; j++)
                i2[j] += y1[i] * w2[i][j];

        // y2
        y2 = new double[n2];
        for (int j = 0; j < n2; j++)
            y2[j] = g.compute(i2[j]);

        // i3
        i3 = new double[n3];
        for (int i = 0; i < n2; i++)
            for (int j = 0; j < n3; j++)
                i3[j] += y2[i] * w3[i][j];

        // y3
        y3 = new double[n3];
        for (int j = 0; j < n3; j++)
            y3[j] = g.compute(i3[j]);

        return Arrays.copyOf(y3, y3.length);
    }

    private void backPropagate(DataSet dataSet, int sampleIndex)
    {
        // delta3
        double[] delta3 = new double[n3];
        for (int j = 0; j < n3; j++)
            delta3[j] = (d[j] - y3[j]) * g.computeFirstDerivative(i3[j]);

        // w3
        for (int i = 0; i < n2; i++)
            for (int j = 0; j < n3; j++)
                w3[i][j] += n * delta3[j] * y2[i];

        // delta2
        double[] delta2 = new double[n2];
        for (int j = 0; j < n2; j++)
        {
            delta2[j] = 0.0;
            for (int k = 0; k < n3; k++)
                delta2[j] += delta3[k] * w3[j][k];
            delta2[j] *= g.computeFirstDerivative(i2[j]);
        }

        // w2
        for (int i = 0; i < n1; i++)
            for (int j = 0; j < n2; j++)
                w2[i][j] += n * delta2[j] * y1[i];

        // delta1
        double[] delta1 = new double[n1];
        for (int j = 0; j < n1; j++)
        {
            delta1[j] = 0.0;
            for (int k = 0; k < n2; k++)
                delta1[j] += delta2[k] * w2[j][k];
            delta1[j] *= g.computeFirstDerivative(i1[j]);
        }

        // w1
        for (int i = 0; i < dataSet.getNumberOfFeatures(); i++)
            for (int j = 0; j < n1; j++)
                w1[i][j] += n * delta1[j] * x[sampleIndex][i];
    }

    private double[][] generateRandomSynapticWeightsMatrix(int ni, int nj)
    {
        Random random = new Random(42L);
        double[][] w = new double[ni][nj];
        for (int i = 0; i < ni; i++)
            w[i] = random.doubles(nj).toArray();
        return w;
    }
}
