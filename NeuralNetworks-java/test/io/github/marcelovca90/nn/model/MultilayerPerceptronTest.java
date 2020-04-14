package io.github.marcelovca90.nn.model;

import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import io.github.marcelovca90.nn.data.DataSet;
import io.github.marcelovca90.nn.data.sample.TicTacToeEndgame;
import io.github.marcelovca90.nn.math.ActivationFunction;
import io.github.marcelovca90.nn.math.HyperbolicTangent;

public class MultilayerPerceptronTest
{
    private static final double LEARNING_RATE = 1e-6;
    private static final int NEURONS_IN_1ST_HIDDEN_LAYER = 14;
    private static final int NEURONS_IN_2ND_HIDDEN_LAYER = 6;
    private static final ActivationFunction ACTIVATION_FUNCTION = new HyperbolicTangent();
    private static final double ERROR_DELTA_TOLERANCE = 1e-5;
    private static final double DELTA = 1e-9;

    @Test
    public void trainTestEvaluatePlot_withTicTacToeEndgame_shouldConverge() throws InterruptedException
    {
        // given
        DataSet dataSet = new TicTacToeEndgame();
        MultilayerPerceptron network = new MultilayerPerceptron(
            LEARNING_RATE,
            NEURONS_IN_1ST_HIDDEN_LAYER,
            NEURONS_IN_2ND_HIDDEN_LAYER,
            ACTIVATION_FUNCTION,
            ERROR_DELTA_TOLERANCE);

        // when
        network.train(dataSet);
        double accuracy = network.evaluate(dataSet);
        network.plotErrorPerEpoch();

        // then
        assertNotEquals(0.0, accuracy, DELTA);
    }
}
