package io.github.marcelovca90.nn.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import io.github.marcelovca90.nn.data.DataSet;
import io.github.marcelovca90.nn.data.sample.LogicGateAND;
import io.github.marcelovca90.nn.data.sample.LogicGateOR;
import io.github.marcelovca90.nn.data.sample.LogicGateXOR;
import io.github.marcelovca90.nn.math.ActivationFunction;
import io.github.marcelovca90.nn.math.Heaviside;

public class PerceptronTest
{
    private static final double LEARNING_RATE = 1e-2;
    private static final ActivationFunction ACTIVATION_FUNCTION = new Heaviside();
    private static final double DELTA = 1e-9;

    @Test
    public void trainTestEvaluatePlot_withLogicGateAND_shouldConverge()
    {
        // given
        DataSet dataSet = new LogicGateAND();
        NeuralNetwork network = new Perceptron(LEARNING_RATE, ACTIVATION_FUNCTION);

        // when
        double[] weights = network.train(dataSet);
        double accuracy = network.evaluate(weights, dataSet);
        ((Perceptron) network).plotErrorPerEpoch();

        // then
        assertEquals(1.0, accuracy, DELTA);
    }

    @Test
    public void trainTestEvaluatePlot_withLogicGateOR_shouldConverge()
    {
        // given
        DataSet dataSet = new LogicGateOR();
        NeuralNetwork network = new Perceptron(LEARNING_RATE, ACTIVATION_FUNCTION);

        // when
        double[] weights = network.train(dataSet);
        double accuracy = network.evaluate(weights, dataSet);
        ((Perceptron) network).plotErrorPerEpoch();

        // then
        assertEquals(1.0, accuracy, DELTA);
    }

    @Test
    public void trainTestEvaluatePlot_withLogicGateXOR_shouldNotConverge()
    {
        // given
        DataSet dataSet = new LogicGateXOR();
        NeuralNetwork network = new Perceptron(LEARNING_RATE, ACTIVATION_FUNCTION);

        // when
        double[] weights = network.train(dataSet);
        double accuracy = network.evaluate(weights, dataSet);
        ((Perceptron) network).plotErrorPerEpoch();

        // then
        assertNotEquals(1.0, accuracy, DELTA);
    }
}
