package ru.ssau.karanashev.fourier;

import ru.ssau.karanashev.complex.ComplexSample;

/**
 * Date: Sep 22, 2010
 * Time: 9:22:28 PM
 *
 * @author Mukhamed Karanashev
 */
public interface FourierTransformer {
    ComplexSample transform(ComplexSample sample);
}
