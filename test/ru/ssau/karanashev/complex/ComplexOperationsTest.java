package ru.ssau.karanashev.complex;

import junit.framework.TestCase;
import org.junit.Test;

import static ru.ssau.karanashev.TestConstants.EPS;
import static ru.ssau.karanashev.complex.ComplexOperations.*;

/**
 * User: Mukhamed Karanashev
 * Date: Sep 21, 2010
 * Time: 10:36:54 PM
 */
public class ComplexOperationsTest extends TestCase {

    @Test
    public void testAdd() {
        double[] result = new double[2];

        result = add(0, 0, 0, 0, result);

        assertEquals(result[0], 0, EPS);
        assertEquals(result[1], 0, EPS);

        double[] aa = new double[]{0, 0};
        double[] bb = new double[]{0, 0};

        result = add(aa, bb, result);
        assertEquals(result[0], 0, EPS);
        assertEquals(result[1], 0, EPS);

        result = add(1, 2, 3, 4, result);
        assertEquals(result[0], 4, EPS);
        assertEquals(result[1], 6, EPS);
    }

    @Test
    public void testAddException() {
        try {
            add(null, new double[4], null);
        } catch (IllegalArgumentException e) {
            return;
        }
        fail();
    }

    @Test
    public void testSub() {
        double[] result = sub(0, 0, 0, 0, null);

        assertEquals(result[0], 0, EPS);
        assertEquals(result[1], 0, EPS);

        result = sub(1, 2, 3, 4, result);

        assertEquals(result[0], -2, EPS);
        assertEquals(result[1], -2, EPS);
    }

    @Test
    public void testSubException() {
        try {
            sub(new double[2], new double[1], null);
        } catch (IllegalArgumentException e) {
            return;
        }
        fail();
    }

    @Test
    public void testMult() {
        double a = 0, b = 0, c = 0, d = 0;

        double[] result = new double[2];
        double[] resultArr = new double[2];

        result = mult(a, b, c, d, result);

        assertEquals(result[0], 0, EPS);
        assertEquals(result[1], 0, EPS);

        double[] aa = new double[]{0, 0};
        double[] bb = new double[]{0, 0};
        resultArr = mult(aa, aa, resultArr);

        assertEquals(resultArr[0], 0, EPS);
        assertEquals(resultArr[1], 0, EPS);

        a = 1;
        result = mult(a, a, a, a, result);

        assertEquals(result[0], 0, EPS);
        assertEquals(result[1], 2, EPS);

        aa = new double[]{1, 1};
        bb = new double[]{1, 1};
        resultArr = mult(aa, aa, resultArr);

        assertEquals(resultArr[0], 0, EPS);
        assertEquals(resultArr[1], 2, EPS);

        a = b = 1;
        c = 2;
        d = -2;
        result = mult(a, b, c, d, result);

        assertEquals(result[0], 4, EPS);
        assertEquals(result[1], 0, EPS);

        aa = new double[]{1, 1};
        bb = new double[]{2, -2};
        resultArr = mult(aa, bb, resultArr);
        assertEquals(resultArr[0], 4, EPS);
        assertEquals(resultArr[1], 0, EPS);
    }

    @Test
    public void testMultException() {
        try {
            mult(new double[2], new double[1], null);
        } catch (IllegalArgumentException e) {
            return;
        }
        fail();
    }

    @Test
    public void testExp() {
        double w = 0;
        double[] result = new double[2];

        result = exp(w, null);

        assertEquals(result[0], 1, EPS);
        assertEquals(result[1], 0, EPS);

        result = exp(w, result);

        assertEquals(result[0], 1, EPS);
        assertEquals(result[1], 0, EPS);

        w = Math.PI / 2;
        result = exp(w, result);

        assertEquals(result[0], 0, EPS);
        assertEquals(result[1], 1, EPS);

        w = Math.PI;
        result = exp(w, result);

        assertEquals(result[0], -1, EPS);
        assertEquals(result[1], 0, EPS);

        w = -Math.PI / 2;
        result = exp(w, result);

        assertEquals(result[0], 0, EPS);
        assertEquals(result[1], -1, EPS);
    }

    private class TestException extends Exception {
    }
}
