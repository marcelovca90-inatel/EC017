package io.github.marcelovca90.nn.model;

import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import io.github.marcelovca90.nn.data.DataSet;
import io.github.marcelovca90.nn.data.sample.BloodTransfusion;
import io.github.marcelovca90.nn.data.sample.Cryotherapy;
import io.github.marcelovca90.nn.data.sample.Diabetes;
import io.github.marcelovca90.nn.data.sample.TicTacToeEndgame;
import io.github.marcelovca90.nn.math.ActivationFunction;
import io.github.marcelovca90.nn.math.HeavisideSymmetric;

public class AdalineTest
{
    private static final double LEARNING_RATE = 1e-6;
    private static final ActivationFunction ACTIVATION_FUNCTION = new HeavisideSymmetric();
    private static final double ERROR_DELTA_TOLERANCE = 1e-5;
    private static final double DELTA = 1e-9;

    @Test
    public void trainTestEvaluatePlot_withBloodTransfusion_shouldConverge()
    {
        // given
        DataSet dataSet = new BloodTransfusion();
        NeuralNetwork network = new Adaline(LEARNING_RATE, ACTIVATION_FUNCTION, ERROR_DELTA_TOLERANCE);

        // when
        double[] weights = network.train(dataSet);
        double accuracy = network.evaluate(weights, dataSet);
        ((Adaline) network).plotMeanSquaredErrorPerEpoch();

        // then
        assertNotEquals(0.0, accuracy, DELTA);
    }

    @Test
    public void trainTestEvaluatePlot_withDiabetes_shouldConverge()
    {
        // given
        DataSet dataSet = new Diabetes();
        NeuralNetwork network = new Adaline(LEARNING_RATE, ACTIVATION_FUNCTION, ERROR_DELTA_TOLERANCE);

        // when
        double[] weights = network.train(dataSet);
        double accuracy = network.evaluate(weights, dataSet);
        ((Adaline) network).plotMeanSquaredErrorPerEpoch();

        // then
        assertNotEquals(0.0, accuracy, DELTA);
    }

    @Test
    public void trainTestEvaluatePlot_withTicTacToeEndgame_shouldConverge()
    {
        // given
        DataSet dataSet = new TicTacToeEndgame();
        NeuralNetwork network = new Adaline(LEARNING_RATE, ACTIVATION_FUNCTION, ERROR_DELTA_TOLERANCE);

        // when
        double[] weights = network.train(dataSet);
        double accuracy = network.evaluate(weights, dataSet);
        ((Adaline) network).plotMeanSquaredErrorPerEpoch();

        // then
        assertNotEquals(0.0, accuracy, DELTA);
    }

    @Test
    public void trainTestEvaluatePlot_withCryotherapy_shouldConverge()
    {
        // given
        DataSet dataSet = new Cryotherapy();
        NeuralNetwork network = new Adaline(LEARNING_RATE, ACTIVATION_FUNCTION, ERROR_DELTA_TOLERANCE);

        // when
        double[] weights = network.train(dataSet);
        double accuracy = network.evaluate(weights, dataSet);
        ((Adaline) network).plotMeanSquaredErrorPerEpoch();

        // then
        assertNotEquals(0.0, accuracy, DELTA);
    }
}
