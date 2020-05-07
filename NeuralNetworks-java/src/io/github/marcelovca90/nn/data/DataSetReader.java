package io.github.marcelovca90.nn.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

public class DataSetReader
{
    private static final ClassLoader CLASS_LOADER = ClassLoader.getSystemClassLoader();

    public static DataSet readFromFolder(String folder)
    {
        double[][] samples = readInput(folder);
        double[] labels = readOutput(folder);

        return new DataSet(samples, labels);
    }

    public static DataSet readFromFolder(String folder, double bias)
    {
        double[][] samples = readInput(folder);
        double[] labels = readOutput(folder);

        return new DataSet(samples, labels, bias);
    }

    private static double[][] readInput(String folder)
    {
        InputStream stream = CLASS_LOADER.getResourceAsStream(folder + File.separator + "input.txt");
        InputStreamReader streamReader = new InputStreamReader(stream);
        BufferedReader bufferedReader = new BufferedReader(streamReader);

        double[][] data = bufferedReader
            .lines()
            .map(DataSetReader::stringToDoubleArray)
            .collect(Collectors.toList())
            .toArray(new double[0][]);

        try
        {
            bufferedReader.close();
            streamReader.close();
            stream.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return data;
    }

    private static double[] readOutput(String folder)
    {
        InputStream stream = CLASS_LOADER.getResourceAsStream(folder + File.separator + "output.txt");
        InputStreamReader streamReader = new InputStreamReader(stream);
        BufferedReader bufferedReader = new BufferedReader(streamReader);

        double[] data = bufferedReader
            .lines()
            .mapToDouble(Double::parseDouble)
            .toArray();

        try
        {
            bufferedReader.close();
            streamReader.close();
            stream.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return data;
    }

    private static double[] stringToDoubleArray(String line)
    {
        return Arrays.stream(line.split(",")).mapToDouble(Double::parseDouble).toArray();
    }
}
