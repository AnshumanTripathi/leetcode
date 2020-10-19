package problems;

import org.junit.Assert;
import org.junit.Test;

public class MaxAreaHistogramTest {

    private final MaxAreaHistogram maxAreaHistogram = new MaxAreaHistogram();

    @Test
    public void testMaxAreaHistogram() {
        Assert.assertEquals(10, maxAreaHistogram.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
        Assert.assertEquals(12, maxAreaHistogram.largestRectangleArea(new int[]{6, 2, 5, 4, 5, 1, 6}));
        Assert.assertEquals(4, maxAreaHistogram.largestRectangleArea(new int[]{1, 2, 4}));
        Assert.assertEquals(0, maxAreaHistogram.largestRectangleArea(new int[]{0, 0}));
    }
}
