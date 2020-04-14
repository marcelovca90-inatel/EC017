package io.github.marcelovca90.nn.plot;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import javax.swing.JFrame;

import org.junit.Test;

public class PlotUtilsTest
{
    @Test
    public void constructor_shouldReturnNonNullObject()
    {
        // when
        PlotUtils utils = new PlotUtils();

        // then
        assertNotNull(utils);
    }

    @Test
    public void plot_withOnlyOneTuple_shouldNotDisplayPlot()
    {
        // given
        double[] x = new double[] { 0.0 };
        double[] y = new double[] { 0.0 };
        String xLabel = "x";
        String yLabel = "y";

        // when
        JFrame frame = PlotUtils.plot(x, xLabel, y, yLabel);

        // then
        assertNull(frame);
    }

    @Test
    public void plot_withMoreThanOneTuple_shouldDisplayPlot()
    {
        // given
        double[] x = new double[] { 0.0, 1.0, 2.0, 3.0, 4.0 };
        double[] y = new double[] { 0.0, 1.0, 4.0, 9.0, 16.0 };
        String xLabel = "x";
        String yLabel = "y";

        // when
        JFrame frame = PlotUtils.plot(x, xLabel, y, yLabel);

        // then
        assertNotNull(frame);
    }
}
