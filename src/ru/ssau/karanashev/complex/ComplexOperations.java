package ru.ssau.karanashev.complex;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

/**
 * User: Mukhamed Karanashev
 * Date: Sep 21, 2010
 * Time: 10:22:37 PM
 */
public class ComplexOperations {

    /**
     * Summarizes two complex values: a + b*i, c + d*i. Result of addition will be stored
     * in the result array. If result array's length is less than 2 - new array will be createn.
     *
     * @param a
     * @param b
     * @param c
     * @param d
     * @param result
     * @return
     */
    public static double[] add(double a, double b, double c, double d, double[] result) {
        if (!isComplex(result)) {
            result = new double[2];
        }

        result[0] = a + c;
        result[1] = b + d;

        return result;
    }

    /**
     * Summarizes two complex values: a, b. Result of addition will be stored
     * in the result array. If result array's length is less than 2 - new array will be createn.
     *
     * @param a      first complex pair
     * @param b      second complex pair
     * @param result
     * @return reference to result array
     */
    public static double[] add(double[] a, double[] b, double[] result) {
        if (!isComplex(a) || !isComplex(b)) {
            throw new IllegalArgumentException("Arguments must be of complex type (double[2])");
        }

        if (!isComplex(result)) {
            result = new double[2];
        }

        result[0] = a[0] + b[0];
        result[1] = a[1] + b[1];

        return result;
    }

    /**
     * Multiplies two complex values: a + b*i, c + d*i. Result of multiplication will be stored
     * in the result array. If result array's length is less than 2 - new array will be createn.
     *
     * @param a
     * @param b
     * @param c
     * @param d
     * @param result
     * @return reference to result array
     */
    public static double[] mult(double a, double b, double c, double d, double[] result) {
        if (!isComplex(result)) {
            result = new double[2];
        }

        result[0] = a * c - b * d;
        result[1] = b * c + a * d;

        return result;
    }

    /**
     * Multiplies two complex values: a, b. Result of multiplication will be stored
     * in the result array. If result array's length is less than 2 - new array will be createn
     *
     * @param a
     * @param b
     * @param result
     * @return
     */
    public static double[] mult(double[] a, double[] b, double[] result) {
        if (!isComplex(a) || !isComplex(b)) {
            throw new IllegalArgumentException("Arguments must be of complex type (double[2])");
        }

        if (!isComplex(result)) {
            result = new double[2];
        }

        result[0] = a[0] * b[0] - a[1] * b[1];
        result[1] = a[1] * b[0] + a[0] * b[1];

        return result;
    }

    /**
     * Calculates complex exponent exp(i*w). Exponent will be
     *
     * @param w
     * @return
     */
    public static double[] exp(double w, double[] result) {

        if (!isComplex(result)) {
            result = new double[2];
        }

        result[0] = cos(w);
        result[1] = sin(w);

        return result;
    }

    private static boolean isComplex(double[] val) {
        return (val != null && val.length == 2);
    }

}
