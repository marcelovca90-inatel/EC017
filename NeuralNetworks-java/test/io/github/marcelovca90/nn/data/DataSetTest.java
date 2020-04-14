package io.github.marcelovca90.nn.data;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class DataSetTest
{
    private static final double DELTA = 1e-9;

    double[][] samples = new double[][] {
            { 1.0, 2.0, 3.0, 4.0 },
            { 5.0, 6.0, 7.0, 8.0 }
    };

    double[] labels = new double[] {
            -1.0,
            +1.0
    };

    private DataSet dataSet = new DataSet(samples, labels);

    @Test
    public void getSamples_valuesShouldMatch()
    {
        assertNotNull(dataSet.getSamples());
        assertEquals(dataSet.getSamples().length, 2);
        assertArrayEquals(samples[0], dataSet.getSamples()[0], DELTA);
        assertArrayEquals(samples[1], dataSet.getSamples()[1], DELTA);
    }

    @Test
    public void getLabels_valuesShouldMatch()
    {
        assertNotNull(dataSet.getLabels());
        assertEquals(dataSet.getLabels().length, 2);
        assertEquals(labels[0], dataSet.getLabels()[0], DELTA);
        assertEquals(labels[1], dataSet.getLabels()[1], DELTA);
    }

    @Test
    public void getNumberOfClasses_valuesShouldMatch()
    {
        assertNotNull(dataSet.getNumberOfClasses());
        assertEquals(dataSet.getNumberOfClasses(), 2);
    }

    @Test
    public void getNumberOfFeatures_valuesShouldMatch()
    {
        assertNotNull(dataSet.getNumberOfFeatures());
        assertEquals(dataSet.getNumberOfFeatures(), 4);
    }

    @Test
    public void getNumberOfSamples_valuesShouldMatch()
    {
        assertNotNull(dataSet.getNumberOfSamples());
        assertEquals(dataSet.getNumberOfSamples(), 2);
    }
}
