package ru.ssau.karanashev.fourier;

import ru.ssau.karanashev.complex.ComplexOperations;
import ru.ssau.karanashev.complex.ComplexSample;

/**
 * User: Mukhamed Karanashev
 * Date: Sep 21, 2010
 * Time: 10:06:45 PM
 */
public class DiscreteFourierTransformer {

    public ComplexSample transform(ComplexSample sample) {

        int size = sample.size();
        ComplexSample result = new ComplexSample(size);

        for (int i = 0; i < size; i++)
        {
            double reSum = 0.0;
            double imSum = 0.0;

            double baseCoef = - (2 * Math.PI / size) * i;

            double[] tempVal = new double[2];
            
            for (int j = 0; j < size; j++)
            {
                double a = sample.getReal(j);
                double b = sample.getImage(j);

                double[] exp = ComplexOperations.exp(baseCoef * j, tempVal);
                double[] elem = ComplexOperations.mult(a, b, exp[0], exp[1], tempVal);

                reSum += elem[0];
                imSum += elem[1];
            }

            result.setReal(i, reSum);
            result.setImage(i, imSum);
        }

        return result;
    }

    
}
