package ru.ssau.karanashev.complex;

import java.util.List;

/**
 * User: Mukhamed Karanashev
 * Date: Sep 21, 2010
 * Time: 10:06:59 PM
 */
public class ComplexSample {

    double[] real;
    double[] image;

    public ComplexSample(int size) {
        real = new double[size];
        image = new double[size];
    }

    public ComplexSample(List sample)
    {
        real = new double[sample.size()];
        image = new double[sample.size()];

        for (int i = 0; i < sample.size(); i++)
        {
            double val = (Double) sample.get(i);
            real[i] = val;
            image[i] = 0;
        }
    }

    public int size()
    {
        return real.length;
    }

    public double getReal(int n) {
        return real[n];
    }

    public double getImage(int n)
    {
        return image[n];
    }

    public void setReal(int n, double val) {
        real[n] = val;
    }

    public void setImage(int n, double val) {
        image[n] = val;
    }
}
