package ru.ssau.karanashev.fourier;

import junit.framework.TestCase;
import org.junit.Test;
import ru.ssau.karanashev.TestConstants;
import ru.ssau.karanashev.complex.ComplexSample;

import java.util.Random;

/**
 * Date: Sep 23, 2010
 * Time: 12:33:53 AM
 *
 * @author Mukhamed Karanashev
 */
public class FastFourierTransformerTest extends TestCase {

    @Test
    public void testTransform() {
        Random r = new Random();
        int N = 8;

        ComplexSample sample = new ComplexSample(N);

        for (int i = 0; i < N; i++) {
            sample.setReal(i, r.nextDouble());
            sample.setImage(i, r.nextDouble());
        }

        ComplexSample dftResult = new DiscreteFourierTransformer().transform(sample);
        ComplexSample fftResult = new FastFourierTransformer2().transform(sample);

        for (int i = 0; i < N; i++) {
            assertEquals(dftResult.getReal(i), fftResult.getReal(i), TestConstants.EPS);
        }
    }

}
