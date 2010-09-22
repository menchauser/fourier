package ru.ssau.karanashev.fourier;

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

        for (int i = 0; i < size; i++) {

        }

        return resultPair[1];
    }
    
}
