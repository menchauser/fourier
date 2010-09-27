package ru.ssau.karanashev.fourier;

import ru.ssau.karanashev.complex.ComplexOperations;
import ru.ssau.karanashev.complex.ComplexSample;

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

        ComplexSample[] resultPair = new ComplexSample[2];
        resultPair[0] = sample.binaryInverse();
        resultPair[1] = new ComplexSample(size);

        // n - current 'level'
        int n = 2;
        while (n <= size) {

            ComplexSample lhs = resultPair[(n >> 2) % 2];
            ComplexSample rhs = resultPair[1 - (n >> 2) % 2];

            for (int i = 0; i < n / 2; i++) {
                double x0_r = rhs.getReal(i);
                double x0_i = rhs.getImage(i);

                double x1_r = rhs.getReal(i + n / 2);
                double x1_i = rhs.getImage(i + n / 2);

                double coef = -(2 * Math.PI / n) * i;
                double[] exp = ComplexOperations.exp(coef, null);

                double[] t = ComplexOperations.mult(exp[0], exp[1], x1_r, x1_i, null);

                lhs.setReal(i, x0_r + t[0]);
                lhs.setImage(i, x0_i + t[1]);

                lhs.setReal(i + n / 2, x0_r - t[0]);
                lhs.setImage(i + n / 2, x0_i - t[1]);
            }

            n <<= 1;
        }

        return resultPair[(n >> 2) % 2];
    }

}
