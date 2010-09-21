package ru.ssau.karanashev.complex;

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
