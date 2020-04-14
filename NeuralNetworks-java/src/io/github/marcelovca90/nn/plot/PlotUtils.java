package io.github.marcelovca90.nn.plot;

import javax.swing.JFrame;

import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;

public class PlotUtils
{
    public static JFrame plot(double[] x, String xLabel, double[] y, String yLabel)
    {
        JFrame plot = null;

        if (x.length == 1)
        {
            System.out.println("Only one training epoch was performed; no plot to show.");
        }
        else
        {
            // set up
            XYChart chart = QuickChart.getChart(
                xLabel + " vs " + yLabel,
                xLabel,
                yLabel,
                yLabel + "(" + xLabel + ")",
                x,
                y);

            // display
            plot = new SwingWrapper<>(chart).displayChart();
        }
        return plot;
    }
}
