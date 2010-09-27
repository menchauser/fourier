package ru.ssau.karanashev.fourier;

import ru.ssau.karanashev.complex.ComplexSample;

/**
 * Date: Sep 22, 2010
 * Time: 9:22:28 PM
 *
 * @author Mukhamed Karanashev
 */
public interface FourierTransformer {

    /**
     * Performs Fast Fourier Transform
     *
     * @param sample input sample
     * @return output sample in the spectral space
     */
    ComplexSample transform(ComplexSample sample);
}
