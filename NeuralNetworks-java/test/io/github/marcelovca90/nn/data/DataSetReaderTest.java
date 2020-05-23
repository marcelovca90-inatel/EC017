package io.github.marcelovca90.nn.data;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Arrays;

import org.junit.Test;

public class DataSetReaderTest
{
    private static final String INVALID_FOLDER_NAME = "data/foo-bar";
    private static final String VALID_FOLDER_NAME = "data/logic-gate-and";
    private static final double BIAS = -1.0;
    private static final double DELTA = 1e-9;

    @Test
    public void constructor_shouldReturnObject()
    {
        // given
        DataSetReader reader;

        // when
        reader = new DataSetReader();

        // then
        assertNotNull(reader);
    }

    @Test
    public void readFromFolder_withInalidFolder_shouldReturnEmptyDataSet()
    {
        // given
        DataSet dataSet;

        // when
        dataSet = DataSetReader.readFromFolder(INVALID_FOLDER_NAME);

        // then
        assertNotNull(dataSet);
        assertEquals(0, dataSet.getNumberOfSamples());
    }

    @Test
    public void readFromFolder_withValidFolder_shouldReturnNonEmptyDataSet()
    {
        // given
        DataSet dataSet;

        // when
        dataSet = DataSetReader.readFromFolder(VALID_FOLDER_NAME);

        // then
        assertNotNull(dataSet);
        assertEquals(2, dataSet.getNumberOfClasses());
        assertEquals(2, dataSet.getNumberOfFeatures());
        assertEquals(4, dataSet.getNumberOfSamples());
    }

    @Test
    public void readFromFolderPassingBias_withValidFolder_shouldReturnNonEmptyDataSet()
    {
        // given
        DataSet dataSet;

        // when
        dataSet = DataSetReader.readFromFolder(VALID_FOLDER_NAME, BIAS);

        // then
        assertNotNull(dataSet);
        assertEquals(2, dataSet.getNumberOfClasses());
        assertEquals(3, dataSet.getNumberOfFeatures());
        assertEquals(4, dataSet.getNumberOfSamples());
        Arrays
            .stream(dataSet.getSamples())
            .forEach(sample -> assertEquals(BIAS, sample[0], DELTA));
    }
}
