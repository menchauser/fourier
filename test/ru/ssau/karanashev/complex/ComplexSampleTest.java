package ru.ssau.karanashev.complex;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: Sep 23, 2010
 * Time: 12:17:45 AM
 *
 * @author Mukhamed Karanashev
 */
public class ComplexSampleTest extends TestCase {

    @Test
    public void testBinaryInverse() {
        List<Double> test = new ArrayList<Double>(4);
        for (int i = 0; i < 4; i++) {
            test.add(new Double(i));
        }

        ComplexSample sample = new ComplexSample(test);

        for (int i = 0; i < sample.size(); i++) {
            System.out.println(sample.getReal(i));
        }

        ComplexSample result = sample.binaryInverse();

        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.getReal(i));
        }

        assertTrue(true);
    }

}
