package ru.ssau.karanashev.complex;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import ru.ssau.karanashev.TestConstants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Date: Sep 23, 2010
 * Time: 12:17:45 AM
 *
 * @author Mukhamed Karanashev
 */
public class ComplexSampleTest extends TestCase {

    Map<Integer, Integer> inverseFour;
    Map<Integer, Integer> inverseEight;

    @Before
    public void setUp() {
        inverseFour = new HashMap<Integer, Integer>(4);
        inverseFour.put(0, 0);
        inverseFour.put(1, 2);
        inverseFour.put(2, 1);
        inverseFour.put(3, 3);

        inverseEight = new HashMap<Integer, Integer>(8);
        inverseEight.put(0, 0);
        inverseEight.put(1, 4);
        inverseEight.put(2, 2);
        inverseEight.put(3, 6);
        inverseEight.put(4, 1);
        inverseEight.put(5, 5);
        inverseEight.put(6, 3);
        inverseEight.put(7, 7);
    }

    @Test
    public void testBinaryInverse() {
        List<Double> test = new ArrayList<Double>(4);
        for (int i = 0; i < 4; i++) {
            test.add(new Double(i));
        }

        ComplexSample sample = new ComplexSample(test);
        ComplexSample result = sample.binaryInverse();

        for (Map.Entry<Integer, Integer> entry : inverseFour.entrySet()) {
            assertEquals(sample.getReal(entry.getKey()), result.getReal(entry.getValue()), TestConstants.EPS);
        }

        test = new ArrayList<Double>(8);
        for (int i = 0; i < 8; i++) {
            test.add(new Double(i));
        }
        sample = new ComplexSample(test);
        result = sample.binaryInverse();

        for (Map.Entry<Integer, Integer> entry : inverseEight.entrySet()) {
            assertEquals(sample.getReal(entry.getKey()), result.getReal(entry.getValue()), TestConstants.EPS);
        }
    }

}
