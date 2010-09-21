package ru.ssau.karanashev.complex;

import junit.framework.TestCase;

import static ru.ssau.karanashev.complex.ComplexOperations.mult;

/**
 * User: Mukhamed Karanashev
 * Date: Sep 21, 2010
 * Time: 10:36:54 PM
 */
public class ComplexOperationsTest extends TestCase {

    public static final double EPS = 1e-10;

    public void testMult() {
        double a = 0, b = 0, c = 0, d = 0;

        double[] result = new double[2];

        result = mult(a, b, c, d, result);

        assertEquals(result[0], 0, EPS);
        assertEquals(result[1], 0, EPS);

        a = b = c = d = 1;

        result = mult(a, b, c, d, result);

        assertEquals(result[0], 0, EPS);
        assertEquals(result[1], 2, EPS);
    }

}
