package ru.ssau.karanashev.fourier;

import ru.ssau.karanashev.complex.ComplexSample;

import static ru.ssau.karanashev.complex.ComplexOperations.*;

/**
 * Date: Sep 22, 2010
 * Time: 9:22:53 PM
 *
 * @author Mukhamed Karanashev
 */
public class FastFourierTransformer2 implements FourierTransformer {

    private static final double EPS = 1e-9;

    public ComplexSample transform(ComplexSample sample) {

        int size = sample.size();

        if ((size & (size - 1)) != 0) {
            throw new IllegalArgumentException("Sample size must be power of 2");
        }

        ComplexSample rhs = sample.binaryInverse();
        ComplexSample lhs = new ComplexSample(size);

        if (size == 2) {
            double[] x0 = rhs.get(0);
            double[] x1 = rhs.get(1);

            double coef = -(Math.PI);

            double[] exp0 = exp(coef * 0, null);

            lhs.set(0, add(x0, mult(exp0, x1, null), null));
            lhs.set(1, sub(x0, mult(exp0, x1, null), null));
        } else if (size == 4) {
            double[] x0 = rhs.get(0);
            double[] x1 = rhs.get(1);
            double[] x2 = rhs.get(2);
            double[] x3 = rhs.get(3);

            // zero step
            double coef = -(2 * Math.PI) / (size / 2);
            double[] exp = exp(coef * 0, null);

            lhs.set(0, add(x0, mult(exp, x1, null), null));
            lhs.set(1, sub(x0, mult(exp, x1, null), null));
            lhs.set(2, add(x2, mult(exp, x3, null), null));
            lhs.set(3, sub(x2, mult(exp, x2, null), null));

            // exchange
            ComplexSample tmp = lhs;
            lhs = rhs;
            rhs = tmp;

            // first and final step
            x0 = rhs.get(0);
            x1 = rhs.get(1);
            x2 = rhs.get(2);
            x3 = rhs.get(3);

            coef = -(2 * Math.PI) / size;
            double[] exp0 = exp(coef * 0, null);
            double[] exp1 = exp(coef * 1, null);

            lhs.set(0, add(x0, mult(exp0, x2, null), null));
            lhs.set(1, sub(x0, mult(exp0, x2, null), null));
            lhs.set(2, add(x1, mult(exp0, x3, null), null));
            lhs.set(3, sub(x1, mult(exp0, x1, null), null));
        }

        return lhs;
    }


    private ComplexSample step(ComplexSample oldSample, ComplexSample newSample, int size) {
        int step = size / 2;

        double coef = -(2 * Math.PI) / size;


        return newSample;
    }
}
