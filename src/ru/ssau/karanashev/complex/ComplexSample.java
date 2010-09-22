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

    /**
     * Initializing sample with list of real parts.
     *
     * @param sample list of Double real parts
     */
    public ComplexSample(List sample) {
        real = new double[sample.size()];
        image = new double[sample.size()];

        for (int i = 0; i < sample.size(); i++) {
            double val = (Double) sample.get(i);
            real[i] = val;
        }
    }

    /**
     * Copying constructor
     *
     * @param sample original sample
     */
    public ComplexSample(ComplexSample sample) {
        int size = sample.size();
        this.real = new double[size];
        this.image = new double[size];

        System.arraycopy(sample.real, 0, this.real, 0, size);
        System.arraycopy(sample.image, 0, this.image, 0, size);
    }

    /**
     * Returns binary inversed sample
     *
     * @return
     */
    public ComplexSample binaryInverse() {
        ComplexSample dst = new ComplexSample(this);

        int n = size();
        int dl = n / 2;
        int st = n - 1;
        int j = 0;

        for (int i = 0; i < st; i++) {
            if (i < j) {
                double tmp = dst.real[i];
                dst.real[i] = dst.real[j];
                dst.real[j] = tmp;
            }

            int k = dl;
            while (k <= j) {
                j -= k;
                k >>= 1;
            }
            j += k;
        }

        return dst;
    }

    /**
     * Get sample size
     *
     * @return sample size
     */
    public int size() {
        return real.length;
    }

    /**
     * Get real part of nth complex value
     *
     * @param n number of complex value in sample
     * @return real part
     */
    public double getReal(int n) {
        return real[n];
    }

    /**
     * Get image part of nth complex value in sample
     *
     * @param n number of complex value in sample
     * @return image part
     */
    public double getImage(int n) {
        return image[n];
    }

    public void setReal(int n, double val) {
        real[n] = val;
    }

    public void setImage(int n, double val) {
        image[n] = val;
    }
}
